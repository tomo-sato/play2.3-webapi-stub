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

package jp.dcworks.webapi.stub.controllers;

import jp.dcworks.webapi.stub.contents.ListContents;
import jp.dcworks.webapi.stub.core.components.db.ActionsComponent;
import jp.dcworks.webapi.stub.views.html.index;
import jp.dcworks.webapi.stub.views.html.list;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * アプリケーションコントローラクラス。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class Application extends Controller {

	/**
	 * デフォルト定義のコントローラクラス。
	 * <p>アプリケーション起動確認用に初期定義のまま提供している。
	 *
	 * @return Result
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/18
	 */
	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	/**
	 * WebAPIスタブの一覧を表示する。
	 *
	 * @return Result
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/18
	 */
	public static Result list() {
		// コンテンツを初期化。
		ListContents contents = new ListContents();

		// アクション一覧取得。
		contents.actionsJoinList = ActionsComponent.findAll();

		return ok(list.render(contents));
	}

	/**
	 * WebAPIスタブの詳細を表示する。
	 *
	 * @param action アクション
	 * @return Result
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/18
	 */
	public static Result detail(String action) {
		// コンテンツを初期化。
		ListContents contents = new ListContents();

		// アクション一覧取得。
		contents.actionsJoinList = ActionsComponent.findAll();

		// アクションを取得する。
		contents.actionsJoin = ActionsComponent.findByApiEndpoint(action);

		return ok(list.render(contents));
	}
}
