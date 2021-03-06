/*
 * Copyright 2017 tomo-sato This software is licensed under the Apache 2 license, quoted below.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.dcworks.webapi.stub.annotations.action;

import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;

import jp.dcworks.java.common_tools.CheckUtils;
import jp.dcworks.webapi.stub.core.components.AppLogger;
import jp.dcworks.webapi.stub.core.components.RequestUtilityComponent;
import play.core.j.JavaResultExtractor;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Request;
import play.mvc.Result;

/**
 * リクエスト、レスポンスパラメータのトレース中継処理クラス。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class ParamsTraceAction extends Action<ParamsTraceAction> {

	@Override
	public Promise<Result> call(Context ctx) throws Throwable {
		Request request = ctx.request();

		final String prefix = new StringBuffer("[" + RandomStringUtils.randomAlphanumeric(20) + "] ")
				.append("method=").append(request.method())
				.append(", url=").append(request.secure() ? "https://" : "http://").append(request.host()).append(request.uri())
				.toString();
		String startPrefix = "■■■start■■■" + prefix;

		Map<String, String[]> map = null;
		if ("GET".equals(request.method())) {
			map = RequestUtilityComponent.getQueryString(request);
		} else {
			map = RequestUtilityComponent.getFromPostStringMap(request);
		}

		StringBuffer buffRequest = new StringBuffer(startPrefix)
				.append("：").append(System.lineSeparator())
				.append("[REQUEST PARAMS]").append(System.lineSeparator());

		StringBuffer buffParams = new StringBuffer();
		if (!CheckUtils.isEmpty(map)) {
			for (Map.Entry<String, String[]> entry : map.entrySet()) {
				String key = entry.getKey();
				String[] valArr = entry.getValue();

				buffParams.append(key).append(":");
				StringBuffer buffValue = new StringBuffer();
				if (valArr != null) {
					for (String val : valArr) {
						buffValue.append(val).append(", ");
					}
				}
				if (buffValue.length() >= 2) {
					buffValue.delete(buffValue.length() - 2, buffValue.length());
				}
				buffParams.append(buffValue);
				buffParams.append(System.lineSeparator());
			}
		}
		if (buffParams.length() >= 2) {
			buffParams.delete(buffParams.length() - 2, buffParams.length());
		}

		buffRequest.append(buffParams).append(System.lineSeparator());
		AppLogger.info(buffRequest.toString());

		try {
			// メイン処理開始
			Promise<Result> promise = delegate.call(ctx);

			if (promise == null) {
				AppLogger.info(prefix + " レスポンスデータ取得：promise=null");
			} else {
				promise.map((result) -> {
					byte[] body = JavaResultExtractor.getBody(result, 0L);

					if (body == null) {
						AppLogger.info(prefix + " レスポンスデータ取得：body=null");
					} else {
						String strBody = new String(body, "UTF-8");

						try {
							JSONObject json = new JSONObject(strBody);
							if (json != null) {
								strBody = json.toString(2);
							}
						} catch (Exception e) {}

						String endPrefix = "■■■ end ■■■" + prefix;
						StringBuffer buffResponse = new StringBuffer(endPrefix)
								.append("：").append(System.lineSeparator())
								.append("[RESPONSE PARAMS]").append(System.lineSeparator())
								.append(strBody).append(System.lineSeparator());

						AppLogger.info(buffResponse.toString());
					}
					return result;
				});
			}

			return promise;
		} catch (Exception e) {
			throw e;
		}
	}
}
