package jp.dcworks.webapi.stub.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * レスポンス（responses）モデル。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
@SuppressWarnings("serial")
@Entity
public class Responses extends AppModel {

	/** レスポンス json */
	@Column(name = "response_json")
	public String responseJson;

	/** 備考 */
	@Column(name = "note")
	public String note;

	/** Finder */
	public static Finder<Long, Responses> find = new Finder<Long, Responses>(
		Long.class, Responses.class
	);
}
