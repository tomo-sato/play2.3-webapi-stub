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

import java.util.List;

import jp.dcworks.java.common_tools.CheckUtils;
import jp.dcworks.webapi.stub.core.models.ActionResponseJoins;
import jp.dcworks.webapi.stub.core.models.Responses;
import jp.dcworks.webapi.stub.core.models.join.ActionsJoin;

/**
 * アクション（actions）モデルの操作を行うコンポーネントクラス。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
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
}
