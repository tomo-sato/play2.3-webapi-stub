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
 * アクション（actions）モデル。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
@SuppressWarnings("serial")
@Entity
public class Actions extends AppModel {

	/** API Endpoint */
	@Column(name = "api_endpoint")
	public String apiEndpoint;

	/** API名 */
	@Column(name = "api_name")
	public String apiName;

	/** 機能詳細 */
	@Column(name = "detail")
	public String detail;

	/** Finder */
	public static Finder<Long, Actions> find = new Finder<Long, Actions>(
		Long.class, Actions.class
	);
}
