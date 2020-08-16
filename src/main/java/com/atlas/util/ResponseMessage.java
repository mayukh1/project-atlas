package com.atlas.util;

public interface ResponseMessage {
	
	public interface ErrorMessages {
		final String COMMON_ERROR ="Some internal error occurs";
		final Integer MUSTI_ERROR_ID = 9999;
		final String STORE_USER = "User and Store mapped error Please add and try again";
		final String STORE_TIMING = "Store Timing creation error Please add and try again";
		final String STORE_UPDATE_CREATE = "Store not created or updated some internal error occurs";
		final String STORE_ALREADY_EXIST = " Store already exist";
		final String USER_NOT_EXIST ="User does not exists";
		final String SEARCH_PARAM_NOT_EXIST ="Search Param does not exists";
		final String URL_NOT_EXIST ="Url does not exists";
		final String NO_STORES_IN_COUNTRY ="No stores available for the country ";
        final String SAME_DATE_RANGE ="Start date and End date should be in the same month";
        final String USERS_NOT_EXIST_USING_PARAM = "User Param does not exists";
		
	}
	
	public interface SuccessMessages { 
		final String STORE_USER = "User and  Store successfully mapped" ;
		final String STORE_TIMING = "Store Times entered successfully" ;
	}

}