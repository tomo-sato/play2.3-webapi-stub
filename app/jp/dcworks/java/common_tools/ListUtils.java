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

import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * リスト操作に関する機能を提供します。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class ListUtils {

	/** Logger定義 */
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(ListUtils.class.getName());

	/**
	 * 引数の{@code list}要素をカンマ区切りの文字列として返します。
	 * 値が{@code null}または、{@code empty}の場合、空文字列（ブランク）を返します。
	 * @param list リスト
	 * @return カンマ区切りの文字列。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static String toString(List<?> list) {
		if (CheckUtils.isEmpty(list)) {
			return "";
		}

		StringBuffer buff = new StringBuffer();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			buff.append(list.get(i)).append(",");
		}

		if (buff.length() > 0) {
			buff.deleteCharAt(buff.length() - 1);
		}
		return buff.toString();
	}
}
