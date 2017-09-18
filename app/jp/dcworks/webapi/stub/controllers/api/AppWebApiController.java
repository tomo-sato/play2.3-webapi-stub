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

import jp.dcworks.webapi.stub.annotations.ParamsTrace;
import play.mvc.Controller;

/**
 * WebAPIコントローラー基底クラス。
 * <p>WebAPIを実装する場合、このクラスを継承する。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
@ParamsTrace
public class AppWebApiController extends Controller {

	/** API結果：0.成功 */
	public static final int API_RES_SUCCESS = 0;

	/** API結果：1.失敗（バリデーションエラー） */
	public static final int API_RES_FAILURE = 1;

	/** API結果：999.システムエラー */
	public static final int API_RES_SYS_ERROR = 999;
}
