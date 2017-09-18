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

		// DBにエンドポイントが登録されていない場合。
		if (actions == null || actions.responses == null) {
			return notFound("エンドポイントが見つかりません。");
		}

		Integer httpStatusCode = actions.responses.httpStatusCode;
		String responseJson = actions.responses.responseJson;

		// レスポンス生成。
		response().setContentType("application/json; charset=utf-8");
		return status(httpStatusCode, responseJson);
	}
}
