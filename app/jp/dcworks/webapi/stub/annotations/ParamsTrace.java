package jp.dcworks.webapi.stub.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jp.dcworks.webapi.stub.annotations.action.ParamsTraceAction;
import play.mvc.With;

/**
 * リクエスト、レスポンスパラメータのトレース中継処理 アノテーション定義。
 * 
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 * @see jp.dcworks.webapi.stub.annotations.action.ParamsTraceAction
 */
@With(ParamsTraceAction.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamsTrace {}
