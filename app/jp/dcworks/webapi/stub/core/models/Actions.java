package jp.dcworks.webapi.stub.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * アクション（actions）モデル。
 *
 * @author tomo-sato
 * @since 1.0.0 2017/09/15
 */
@SuppressWarnings("serial")
@Entity
public class Actions extends AppModel {

	/** API Endpoint */
	@Column(name = "api_endpoint")
	public String apiEndpoint;

	/** API名 */
	@Column(name = "api_name")
	public String apiName;

	/** 機能詳細 */
	@Column(name = "detail")
	public String detail;

	/** Finder */
	public static Finder<Long, Actions> find = new Finder<Long, Actions>(
		Long.class, Actions.class
	);
}
