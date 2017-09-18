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
 * Class関する付属情報を提供します。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class ClassUtils {

	/** Logger定義 */
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(ClassUtils.class.getName());

	/**
	 * このメソッドを参照しているメソッド名を返します。
	 *
	 * @return このメソッドを参照しているメソッド名を返します。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static String getMethodName() {
		Throwable throwable = new Throwable();
		String methodName = "";
		StackTraceElement[] stackTrace = throwable.getStackTrace();

		if (stackTrace != null) {
			if(stackTrace.length > 2){
				methodName = stackTrace[2].getMethodName();
			}
		}
		return methodName;
	}

}
