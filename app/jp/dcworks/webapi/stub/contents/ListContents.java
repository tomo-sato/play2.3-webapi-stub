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

package jp.dcworks.webapi.stub.contents;

import java.util.ArrayList;
import java.util.List;

import jp.dcworks.webapi.stub.core.models.ext.ActionsJoin;
import jp.dcworks.webapi.stub.core.models.Responses;
import play.mvc.Controller;

/**
 * 一覧画面（list.html）に表示するコンテンツを保持するクラス。
 *
 * @author tomo-sato
 * @since 1.1.0 2017/09/18
 */
public class ListContents extends Controller {

	/** アクションリスト */
	public List<ActionsJoin> actionsJoinList = new ArrayList<ActionsJoin>();
	
	/** レスポンスリスト */
	public List<Responses> responseList = new ArrayList<Responses>();

	/** アクション */
	public ActionsJoin actionsJoin = null;
}