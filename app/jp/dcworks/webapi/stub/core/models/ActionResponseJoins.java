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

package jp.dcworks.webapi.stub.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * アクション レスポンス紐付け（action_response_joins）モデル。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
@SuppressWarnings("serial")
@Entity
public class ActionResponseJoins extends AppModel {

	/** アクションID */
	@Column(name = "actions_id")
	public Long actionsId;

	/** レスポンスID */
	@Column(name = "responses_id")
	public Long responsesId;

	/** Finder */
	public static Finder<Long, ActionResponseJoins> find = new Finder<Long, ActionResponseJoins>(
		Long.class, ActionResponseJoins.class
	);
}
