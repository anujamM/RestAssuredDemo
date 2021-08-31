package util;

import base.RESTBase;
import io.restassured.response.Response;

public class Utils extends RESTBase{
	public String getID(Response response) {
		String[] id = response.getHeader("Location").split("/");
		return id[id.length - 1];
	}
}
