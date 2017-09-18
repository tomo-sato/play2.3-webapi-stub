package jp.dcworks.webapi.stub.core.models.join;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import jp.dcworks.webapi.stub.core.models.Actions;
import jp.dcworks.webapi.stub.core.models.Responses;

/**
 * アクション（actions）モデル。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
@SuppressWarnings("serial")
@Entity @Table(name="actions")
public class ActionsJoin extends Actions {

	/** responsesモデル */
	@Transient
	public Responses responses;

	/** Finder */
	public static Finder<Long, ActionsJoin> find = new Finder<Long, ActionsJoin>(
		Long.class, ActionsJoin.class
	);
}
