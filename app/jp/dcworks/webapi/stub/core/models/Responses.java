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
 * レスポンス（responses）モデル。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 * 
 * @version 1.3.0 2017/11/07 レスポンスを編集できるよう機能追加。
 * @version 1.2.0 2017/09/30 レスポンス時間を任意で調整するパラメータ追加。
 */
@SuppressWarnings("serial")
@Entity
public class Responses extends AppModel {

	/** レスポンス json */
	@Column(name = "response_json")
	public String responseJson;

	/** HTTPステータスコード */
	@Column(name = "http_status_code")
	public Integer httpStatusCode;

	/** スリープ時間（デフォルト：0秒） */
	@Column(name = "sleep_time_seconds")
	public Integer sleepTimeSeconds;

	/** 備考 */
	@Column(name = "note")
	public String note;

	/** アクションID */
	@Column(name = "actions_id")
	public String actionsId;

	/** Finder */
	public static Finder<Long, Responses> find = new Finder<Long, Responses>(
		Long.class, Responses.class
	);
}
