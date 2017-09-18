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

package jp.dcworks.java.common_tools;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * 文字列操作に関する機能を提供します。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class StringUtils {

	/** Logger定義 */
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(StringUtils.class.getName());

	/**
	 * 引数{@code value}の値が{@code null}または、
	 * {@link String#trim()}した結果が{@link String#isEmpty()}の場合、
	 * {@code true}を返します。
	 *
	 * @param value チェック対象の文字列
	 * @return 引数{@code value}の値が{@code null}または、
	 * 			{@link String#trim()}した結果が{@link String#isEmpty()}の場合、{@code true}。
	 * 			それ以外{@code false}。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static boolean isEmptyWithTrim(String value) {
		if (value == null || value.trim().isEmpty()) {
			return true;
		}
		return false;
	}

}
