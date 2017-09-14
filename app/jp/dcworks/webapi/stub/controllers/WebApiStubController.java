package jp.dcworks.webapi.stub.controllers;

import jp.dcworks.webapi.stub.views.html.index;
import play.mvc.Result;

/**
 * スタブAPI メインクラス。
 * 
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
public class WebApiStubController extends AppWebApiController {

	/**
	 * スタブAPI メインアクション。
	 * 
	 * @return Result
	 * 
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}
}
