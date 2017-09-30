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

package jp.dcworks.webapi.stub.controllers.api;

import jp.dcworks.webapi.stub.core.components.db.ActionsComponent;
import jp.dcworks.webapi.stub.core.models.ext.ActionsJoin;
import play.mvc.Result;

/**
 * スタブAPI メインクラス。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 * @version 1.2.0 2017/09/30 レスポンス時間を任意で調整する機能追加。
 */
public class WebApiStubController extends AppWebApiController {

	/**
	 * スタブAPI メインアクション。
	 * <p>エンドポイントの文字列よりレスポンスを取得する。
	 *
	 * @param action アクション
	 * @return Result
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 * @version 1.2.0 2017/09/30 レスポンス時間を任意で調整する機能追加。
	 */
	public static Result index(String action) {

		// アクションを取得する。
		ActionsJoin actions = ActionsComponent.findByApiEndpoint(action);

		// DBにエンドポイントが登録されていない場合。
		if (actions == null || actions.responses == null) {
			return notFound("エンドポイントが見つかりません。");
		}

		Integer httpStatusCode = actions.responses.httpStatusCode;
		String responseJson = actions.responses.responseJson;

		// DBにエンドポイントが登録されていない場合。
		if (responseJson == null || responseJson.length() <= 0) {
			return notFound("レスポンスが取得できません。");
		}

		try {
			// レスポンス時間を任意で調整する。
			Thread.sleep(actions.responses.sleepTimeSeconds * 1000);
		} catch (Exception e) {}

		// レスポンス生成。
		response().setContentType("application/json; charset=utf-8");
		return status(httpStatusCode, responseJson);
	}
}
