package com.atlas.util;

public interface API {
	public interface Authentication { 
		final String USER_AUTHENTICATION = "/login" ;
		final String TOKEN_VALIDATOR="/token/validate";
		final String GET_ALL_SEATS="/allSeats";
	}

}
