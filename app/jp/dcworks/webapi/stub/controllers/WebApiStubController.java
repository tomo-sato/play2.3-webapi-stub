package jp.dcworks.webapi.stub.controllers;

import jp.dcworks.webapi.stub.core.components.db.ActionsComponent;
import jp.dcworks.webapi.stub.core.models.join.ActionsJoin;
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
	 * @param action アクション
	 * @return Result
	 *
	 * @author tomo-sato
	 * @since 1.0.0 2017/09/15
	 */
	public static Result index(String action) {

		// アクションを取得する。
		ActionsJoin actions =ActionsComponent.findByApiEndpoint(action);

		return ok(actions.responses.responseJson);
	}
}
