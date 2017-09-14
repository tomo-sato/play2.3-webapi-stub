package jp.dcworks.java.common_tools;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

/**
 * オブジェクトチェックに関する機能を提供します。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class CheckUtils {

	/** Logger定義 */
	private static Logger LOGGER = (Logger) LoggerFactory.getLogger(CheckUtils.class.getName());

	/**
	 * 引数の{@code list}が{@code null}または、
	 * {@link List#isEmpty()}の場合{@code true}を返します。
	 * 要素が存在する場合は{@code false}を返します。
	 *
	 * @param list チェック対象のリスト
	 * @return 引数の{@code list}が{@code null}または、
	 * 			{@link List#isEmpty()}の場合{@code true}。
	 * 			要素が存在する場合は{@code false}。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static boolean isEmpty(List<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 引数の{@code map}が{@code null}または、
	 * {@link Map#isEmpty()}の場合{@code true}を返します。
	 * 要素が存在する場合は{@code false}を返します。
	 *
	 * @param map チェック対象のマップ
	 * @return 引数の{@code map}が{@code null}または、
	 * 			{@link Map#isEmpty()}の場合{@code true}。
	 * 			要素が存在する場合は{@code false}。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 引数の{@code str}が{@code null}または、
	 * {@link String#isEmpty()}の場合{@code true}を返します。
	 * 要素が存在する場合は{@code false}を返します。
	 *
	 * @param str チェック対象の文字列
	 * @return 引数の{@code str}が{@code null}または、
	 * 			{@link Map#isEmpty()}の場合{@code true}。
	 * 			要素が存在する場合は{@code false}。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 引数の{@code num}が{@code null}または、
	 * {@link Number#doubleValue()}の結果が0.0以下の場合{@code true}を返します。
	 * 要素が存在する場合は{@code false}を返します。
	 *
	 * @param num チェック対象の数値
	 * @return 引数の{@code num}が{@code null}または、
	 * 			{@link Number#doubleValue()}の結果が0.0以下の場合{@code true}。
	 * 			要素が存在する場合は{@code false}。
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static boolean isEmpty(Number num) {
		if (num == null || num.doubleValue() <= 0.0) {
			return true;
		}
		return false;
	}
}
