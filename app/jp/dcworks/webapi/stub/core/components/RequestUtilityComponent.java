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

package jp.dcworks.webapi.stub.core.components;

import java.util.Map;

import play.mvc.Http.MultipartFormData;
import play.mvc.Http.Request;

/**
 * Requestに関するユーティリティクラス。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class RequestUtilityComponent {

	/** ブランク文字列 */
	public static final String BLANK = "";

	/**
	 * リクエストからkeyのクエリ文字列を取得する。
	 * @param request リクエスト
	 * @param key キー
	 * @return クエリ文字列
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static String getQueryString(Request request, String key) {
		if (request == null
				|| key == null
				|| key.length() <= 0) {

			AppLogger.debug("Parameter error：request=" + request + ", key=" + key);
			return null;
		}
		return request.getQueryString(key);
	}

	/**
	 * リクエストからクエリ文字列Mapを取得する。
	 * @param request リクエスト
	 * @return クエリ文字列Map
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static Map<String, String[]> getQueryString(Request request) {
		if (request == null) {

			AppLogger.debug("Parameter error：request=" + request);
			return null;
		}
		return request.queryString();
	}

	/**
	 * リクエストからkeyのFrom文字列を取得する。
	 * @param request リクエスト
	 * @param key キー
	 * @return Post文字列
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static String getFromPostString(Request request, String key) {
		if (request == null
				|| request.body() == null
				|| request.body().asMultipartFormData() == null
				|| key == null
				|| key.length() <= 0) {

			AppLogger.debug("Parameter error：request=" + request + ", key=" + key);
			return null;
		}

		MultipartFormData form = request.body().asMultipartFormData();
		if (form == null
				|| form.asFormUrlEncoded() == null
				|| form.asFormUrlEncoded().get(key) == null
				|| form.asFormUrlEncoded().get(key).length <= 0) {

			AppLogger.debug("Form error：form=" + form + ", key=" + key);
			return null;
		}

		String str = form.asFormUrlEncoded().get(key)[0];
		return str;
	}

	/**
	 * リクエストからkeyのFrom文字列を取得する。
	 * @param request リクエスト
	 * @param key キー
	 * @return Post文字列
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static String[] getFromPostStrings(Request request, String key) {
		if (request == null
				|| request.body() == null
				|| request.body().asMultipartFormData() == null
				|| key == null
				|| key.length() <= 0) {

			AppLogger.debug("Parameter error：request=" + request + ", key=" + key);
			return null;
		}

		MultipartFormData form = request.body().asMultipartFormData();
		if (form == null
				|| form.asFormUrlEncoded() == null
				|| form.asFormUrlEncoded().get(key) == null) {

			AppLogger.debug("Form error：form=" + form + ", key=" + key);
			return null;
		}

		String[] str = form.asFormUrlEncoded().get(key);
		return str;
	}

	/**
	 * リクエストからPostパラメータのMapを取得する。
	 * @param request リクエスト
	 * @return PostパラメータのMap
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static Map<String, String[]> getFromPostMap(Request request) {
		if (request == null
				|| request.body() == null
				|| request.body().asMultipartFormData() == null) {

			AppLogger.debug("Parameter error：request=" + request);
			return null;
		}

		MultipartFormData form = request.body().asMultipartFormData();
		if (form == null
				|| form.asFormUrlEncoded() == null) {

			AppLogger.debug("Form error：form=" + form);
			return null;
		}
		return form.asFormUrlEncoded();
	}

	/**
	 * リクエストからkeyのFrom文字列を取得する。
	 * @param request リクエスト
	 * @param key キー
	 * @return Post文字列
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static String getFromPostStringNullToBlank(Request request, String key) {
		if (request == null
				|| request.body() == null
				|| request.body().asMultipartFormData() == null
				|| key == null
				|| key.length() <= 0) {

			AppLogger.debug("Parameter error：request=" + request + ", key=" + key);
			return BLANK;
		}

		MultipartFormData form = request.body().asMultipartFormData();
		if (form == null
				|| form.asFormUrlEncoded() == null
				|| form.asFormUrlEncoded().get(key) == null
				|| form.asFormUrlEncoded().get(key).length <= 0) {

			AppLogger.debug("Form error：form=" + form + ", key=" + key);
			return BLANK;
		}

		String str = form.asFormUrlEncoded().get(key)[0];
		return (str == null) ? BLANK : str;
	}


	/**
	 * リクエストからFrom文字列Mapを取得する。
	 * @param request リクエスト
	 * @return Post文字列Map
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static Map<String, String[]> getFromPostStringMap(Request request) {
		if (request == null
				|| request.body() == null
				|| request.body().asMultipartFormData() == null) {

			AppLogger.debug("Parameter error：request=" + request);
			return null;
		}

		MultipartFormData form = request.body().asMultipartFormData();
		if (form == null
				|| form.asFormUrlEncoded() == null) {

			AppLogger.debug("Form error：form=" + form);
			return null;
		}

		return form.asFormUrlEncoded();
	}
}
