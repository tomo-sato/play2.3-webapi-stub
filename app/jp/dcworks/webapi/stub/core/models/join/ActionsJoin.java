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

package jp.dcworks.webapi.stub.core.models.join;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import jp.dcworks.webapi.stub.core.models.Actions;
import jp.dcworks.webapi.stub.core.models.Responses;

/**
 * アクション（actions）モデル。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
@SuppressWarnings("serial")
@Entity @Table(name="actions")
public class ActionsJoin extends Actions {

	/** responsesモデル */
	@Transient
	public Responses responses;

	/** Finder */
	public static Finder<Long, ActionsJoin> find = new Finder<Long, ActionsJoin>(
		Long.class, ActionsJoin.class
	);
}
