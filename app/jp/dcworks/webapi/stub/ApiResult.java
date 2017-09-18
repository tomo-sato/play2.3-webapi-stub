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

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;

/**
 * API結果格納クラス。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class ApiResult {

	/** 処理結果 **/
	private Integer result;

	/** コンテンツ **/
	private Map<String, Object> content;


	/**
	 * 処理結果{@code result}で初期化したコンストラクタ。
	 * @param result 処理結果
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public ApiResult(Integer result) {
		super();
		this.result = result;
		this.content = new HashMap<String, Object>();
	}

	/**
	 * 処理結果{@code result}、コンテンツ{@code content}で初期化したコンストラクタ。
	 * @param result 処理結果
	 * @param content コンテンツ
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public ApiResult(Integer result, Map<String, Object> content) {
		super();
		this.result = result;
		this.content = content;
	}

	/**
	 * 処理結果をセットする。
	 * @param result 処理結果
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public void setResult(Integer result) {
		this.result = result;
	}

	/**
	 * コンテンツをセットする。
	 * @param content コンテンツ
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public void setContent(Map<String, Object> content) {
		this.content = content;
	}

	/**
	 * エラーコンテンツをセットする。
	 * @param errorsAsJson json形式のエラーメッセージ
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public void setErrors(JsonNode errorsAsJson) {
		content.put("errors", errorsAsJson);
	}

	/**
	 * コンテンツレンダリング処理。
	 * @return JSON jsonオブジェクト
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public JsonNode render() {
		content.put("result", result);
		return Json.toJson(content);
	}
}
