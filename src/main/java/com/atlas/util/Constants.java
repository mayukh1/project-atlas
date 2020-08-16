package com.atlas.util;

public class Constants {
	public static final String TARGET_SERVICE = "targetService";
	public static final String HEADER_STRING = "Authorization";
	public static final String USER_INFO_HEADER_NAME = "x-user-info";
	public static String SUCCESS = "success";

	public static int UNAUTHORIZED_ID = 401;
	public static int SUCCESS_ID = 200;
	public static int FAILURE_ID = 320;
	public static String UNAUTHORIZED = "Invalid credentials. Please try again.";
	public static String PROCESS_FAIL = "Process failed, Please try again.";
	public static String IMAGE_FILE_TYPE = "JPG,JPEG,PNG,GIF";
	public static final String DATE_OF_FORMAT = "dd/MM/yyyy HH:mm";
	public static final String DATE_OF_FORMAT_NOT = "dd/MM/yyyy";
	public static final String HEADER_APPLICATION_JSON = "application/json";
	public static final String ERROR_CODE = "errorCode";
	public static final String ERROR_FIELD = "errorField";
	public static final String ERROR_MESSAGE_CODE = "errorMessageCode";
	public static final String ERROR_MESSAGE_VALUE = "common.error.";
	public static final String POSTER_IMAGE= "movie poster";

	public static enum ErrorType {
		        Error1(1, "image file is greater than 5mb"),
		        Error2(2, "label.graptive.error.code.002"),
		        Error3(3, "label.graptive.error.code.003");
		    
		    private int errorId;
	        private String value;
	        ErrorType( int errorId,String value) {
	            this.errorId = errorId;
	            this.value = value;
	        }
	        public int getErrorId() {
	            return errorId;
	        }
	        public void setErrorId(int errorId) {
	            this.errorId = errorId;
	        }

	        public String getValue() {
	            return value;
	        }

	        public void setValue(String value) {
	            this.value = value;
	        }

	}
}
