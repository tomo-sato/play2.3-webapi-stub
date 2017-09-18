package jp.dcworks.webapi.stub.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * アクション レスポンス紐付け（action_response_joins）モデル。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
@SuppressWarnings("serial")
@Entity
public class ActionResponseJoins extends AppModel {

	/** アクションID */
	@Column(name = "actions_id")
	public Long actionsId;

	/** レスポンスID */
	@Column(name = "responses_id")
	public String responsesId;

	/** Finder */
	public static Finder<Long, ActionResponseJoins> find = new Finder<Long, ActionResponseJoins>(
		Long.class, ActionResponseJoins.class
	);
}
