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

import java.math.BigDecimal;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * 数値操作に関する機能を提供します。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class NumberUtils {

	/** Logger定義 */
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(NumberUtils.class.getName());

	/**
	 * 引数の文字列を{@link BigDecimal}型に変換します。
	 * 変換に失敗した場合、値0の{@code BigDecimal}型を返します。
	 *
	 * @param str {@code BigDecimal}に変換する文字列
	 * @return 変換後の値
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static BigDecimal toBigDecimal(String str) {
		return toBigDecimal(str, "0");
	}

	/**
	 * 引数の文字列を{@link BigDecimal}型に変換します。
	 * 変換に失敗した場合、{@code defaultValue}の値で{@code BigDecimal}を返します。
	 *
	 * @param str {@code BigDecimal}に変換する文字列
	 * @param defaultValue デフォルト値（{@code null}をデフォルトとすることも可能です。）
	 * @return 変換後の値
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static BigDecimal toBigDecimal(String str, String defaultValue) {
		if (str == null) {
			if (defaultValue == null) {
				return null;
			}
			return new BigDecimal(defaultValue);
		}
		try {
			return new BigDecimal(str);
		} catch (Exception e) {
			LOGGER.warn("変換に失敗しました。", e);
		}
		if (defaultValue == null) {
			return null;
		}
		return new BigDecimal(defaultValue);
	}

}
