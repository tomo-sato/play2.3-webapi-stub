package jp.dcworks.webapi.stub.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * アクション レスポンス紐付け（action_response_join）モデル。
 * 
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
@SuppressWarnings("serial")
@Entity
public class ActionResponseJoin extends AppModel {

	/** アクションID */
	@Column(name = "actions_id")
	public Long actionsId;

	/** レスポンスID */
	@Column(name = "responses_id")
	public String responsesId;
}
