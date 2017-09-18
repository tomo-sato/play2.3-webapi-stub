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

package jp.dcworks.webapi.stub;


import jp.dcworks.webapi.stub.controllers.AppWebApiController;
import jp.dcworks.webapi.stub.core.components.AppLogger;
import play.Application;
import play.GlobalSettings;
import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import play.mvc.Results;

/**
 * アプリケーショングローバル設定クラス。
 * <p>起動、停止、エラー関連のイベントリスナーを実装。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class Global extends GlobalSettings {

	/**
	 * アプリケーション起動イベント。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 * @see play.GlobalSettings#onStart(play.Application)
	 */
	@Override
	public void onStart(Application app) {
		super.onStart(app);
		AppLogger.info("=== Sena-api start ===");
	}

	/**
	 * アプリケーション停止イベント。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 * @see play.GlobalSettings#onStop(play.Application)
	 */
	@Override
	public void onStop(Application app) {
		AppLogger.info("=== Sena-api stop ===");
		super.onStop(app);
	}

	/**
	 * 404：アクションが見つからない場合。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 * @see play.GlobalSettings#onHandlerNotFound(play.mvc.Http.RequestHeader)
	 */
	@Override
	public Promise<Result> onHandlerNotFound(RequestHeader request) {
		AppLogger.warn(new StringBuffer("Request 404 Error：request=").append(request).toString());

		// API結果：1.失敗
		ApiResult ret = new ApiResult(AppWebApiController.API_RES_FAILURE);
		return Promise.<Result>pure(Results.notFound(ret.render()));
	}

	/**
	 * 400：リクエストエラー。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 * @see play.GlobalSettings#onBadRequest(play.mvc.Http.RequestHeader, java.lang.String)
	 */
	@Override
	public Promise<Result> onBadRequest(RequestHeader request, String error) {
		AppLogger.warn(new StringBuffer("Request 400 Error：request=").append(request).append(", error=").append(error).toString());

		// API結果：1.失敗
		ApiResult ret = new ApiResult(AppWebApiController.API_RES_FAILURE);
		return Promise.<Result>pure(Results.badRequest(ret.render()));
	}

	/**
	 * 500：エラー共通。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 * @see play.GlobalSettings#onError(play.mvc.Http.RequestHeader, java.lang.Throwable)
	 */
	@Override
	public Promise<Result> onError(RequestHeader request, Throwable t) {
		AppLogger.error(new StringBuffer("Request 500 Error：request=").append(request).toString(), t);

		// 999.システムエラー
		ApiResult ret = new ApiResult(AppWebApiController.API_RES_SYS_ERROR);
		return Promise.<Result>pure(Results.internalServerError(ret.render()));
	}
}
