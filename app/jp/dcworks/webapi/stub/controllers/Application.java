package jp.dcworks.webapi.stub.controllers;

import jp.dcworks.webapi.stub.views.html.index;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

}