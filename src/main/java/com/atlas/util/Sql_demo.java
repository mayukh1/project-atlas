package com.atlas.util;

public interface Sql_demo {

	final String ID = "id";

	public interface entertainment {
		
		final String GET_URL = "SELECT bu_url FROM entertainment WHERE bu_genre = ? AND bu_name = ?" ;
		
	}

}
