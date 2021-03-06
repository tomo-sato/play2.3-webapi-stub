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

package jp.dcworks.webapi.stub.core.components.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.dcworks.java.common_tools.CheckUtils;
import jp.dcworks.webapi.stub.core.models.ActionResponseJoins;
import jp.dcworks.webapi.stub.core.models.Responses;
import jp.dcworks.webapi.stub.core.models.ext.ActionsJoin;

/**
 * アクション（actions）モデルの操作を行うコンポーネントクラス。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 * 
 * @version 1.3.0 2017/11/07 レスポンスを編集できるよう機能追加。
 * @version 1.1.0 2017/09/18 WebAPIスタブ一覧画面、詳細画面の製造。
 */
public class ActionsComponent {

	/**
	 * 引数のエンドポイント {@code apiEndpoint} より有効なアクションを取得する。
	 *
	 * @param apiEndpoint エンドポイント
	 * @return アクションを返す。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/16
	 */
	public static ActionsJoin findByApiEndpoint(String apiEndpoint) {

		ActionsJoin actions = ActionsJoin.find
				.where()
				.eq("delete_flg", false)
				.eq("api_endpoint", apiEndpoint)
				.findUnique();

		if (actions == null) {
			return null;
		}

		// 紐付けテーブルを検索
		List<ActionResponseJoins> actionResponseJoinsList = ActionResponseJoins.find
				.where()
				.eq("delete_flg", false)
				.eq("actions_id", actions.id)
				.findList();

		if (!CheckUtils.isEmpty(actionResponseJoinsList)) {
			ActionResponseJoins actionResponseJoins = actionResponseJoinsList.get(0);

			Responses responses = Responses.find
					.where()
					.eq("delete_flg", false)
					.eq("id", actionResponseJoins.responsesId)
					.findUnique();

			actions.responses = responses;
		}

		return actions;
	}

	/**
	 * 有効なエンドポイントの一覧を取得する。
	 *
	 * @return エンドポイントの一覧
	 *
	 * @author tomo-sato
	 * @since 1.1.0 2017/09/18
	 */
	public static List<ActionsJoin> findAll() {

		Map<Long, ActionsJoin> actionsMap = ActionsJoin.find
				.where()
				.eq("delete_flg", false)
				.findMap("id", Long.class);

		if (CheckUtils.isEmpty(actionsMap)) {
			return null;
		}

		// in句に指定するIDリストを生成する。
		List<Long> actionsIdList = new ArrayList<Long>();
		for (Map.Entry<Long, ActionsJoin> entry : actionsMap.entrySet()) {
			actionsIdList.add(entry.getKey());
		}

		// 紐付けテーブルを検索
		List<ActionResponseJoins> actionResponseJoinsList = ActionResponseJoins.find
				.where()
				.eq("delete_flg", false)
				.in("actions_id", actionsIdList)
				.findList();

		List<ActionsJoin> retList = new ArrayList<ActionsJoin>();
		if (!CheckUtils.isEmpty(actionResponseJoinsList)) {

			// in句に指定するIDリストを生成する。
			List<Long> responsesIdList = new ArrayList<Long>();
			for (ActionResponseJoins actionResponseJoins : actionResponseJoinsList) {
				responsesIdList.add(actionResponseJoins.responsesId);
			}

			// レスポンステーブルを検索
			Map<Long, Responses> responsesMap = Responses.find
					.where()
					.eq("delete_flg", false)
					.in("id", responsesIdList)
					.findMap("id", Long.class);

			if (!CheckUtils.isEmpty(responsesMap)) {
				for (ActionResponseJoins actionResponseJoins : actionResponseJoinsList) {
					Long actionsId = actionResponseJoins.actionsId;
					Long responsesId = actionResponseJoins.responsesId;

					actionsMap.get(actionsId).responses = responsesMap.get(responsesId);
					retList.add(actionsMap.get(actionsId));
				}
			}
		}

		return retList;
	}

	/**
	 * 有効なレスポンス一覧を取得する。
	 *
	 * @param actionId アクションID
	 * @return レスポンスの一覧
	 *
	 * @author y.marui
	 * @since 1.3.0 2017/11/07
	 */
	public static List<Responses> findResponseByActionsId(Long actionId) {

		// レスポンステーブルを検索
		List<Responses> responsesList = Responses.find
				.where()
				.eq("delete_flg", false)
				.eq("actions_id", actionId)
				.findList();

		return responsesList;
	}

	/**
	 * アクション-レスポンステーブルの値を変更する
	 *
	 * @param actionsId アクションID
	 * @param responsesId レスポンスID
	 *
	 * @author y.marui
	 * @since 1.3.0 2017/11/07
	 */
	public static void updateActionResponseJoins(Long actionsId, Long responsesId) {

		ActionResponseJoins actionResponseJoin = ActionResponseJoins.find
				.where()
				.eq("delete_flg", false)
				.eq("actions_id", actionsId)
				.findUnique();

		actionResponseJoin.responsesId = responsesId;
		actionResponseJoin.update();
	}

	/**
	 * レスポンステーブルの値を変更する
	 *
	 * @param json レスポンスのjson
	 * @param responsesId レスポンスID
	 *
	 * @author y.marui
	 * @since 1.3.0 2017/11/07
	 */
	public static void updateResponse(String json, Long responsesId) {

		Responses response = Responses.find
				.where()
				.eq("delete_flg", false)
				.eq("id", responsesId)
				.findUnique();

		response.responseJson = json;
		response.update();
	}
	
	/**
	 * レスポンステーブルにデータを追加する
	 *
	 * @param actionId アクションID
	 * @param json レスポンスのjson
	 * @param note 備考
	 *
	 * @author y.marui
	 * @since 1.3.0 2017/11/10
	 */
	public static void addResponse(Long actionId, String json, String note) {
		Responses response = new Responses();
		response.responseJson = json;
		response.httpStatusCode = 200;
		response.note = note;
		response.actionsId = actionId;
		response.sleepTimeSeconds = 0;
		response.save();
	}
}
