package com.atlas.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atlas.dto.Url;
import com.atlas.service.AtlasService;
import com.atlas.util.ResponseGenerator;
import com.atlas.util.ResponseMessage;
import com.fasterxml.jackson.core.JsonProcessingException;

@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + "; charset=UTF-8")
@RestController
@RequestMapping("/atlas/entertinment")
public class AtlasController {
	@Autowired
	private AtlasService atlasService;

	public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AtlasController.class);
	
	@GetMapping(value = "/getUrl")
	public String getUrlPerReq(@QueryParam("searchParam") String searchParam,
			@QueryParam("searchParam1") String searchParam1) throws JsonProcessingException {
		LOGGER.info("Returning all the URL details ");
		Url uRL;
		try {
			if ((searchParam == null || searchParam == "") && (searchParam1 == null || searchParam1 == "")) {
				return ResponseGenerator.failureResponse(ResponseMessage.ErrorMessages.SEARCH_PARAM_NOT_EXIST);
			}
			uRL = atlasService.getUrl(searchParam,searchParam1);
			if (uRL.equals(null)) {
				return ResponseGenerator.failureResponse(ResponseMessage.ErrorMessages.URL_NOT_EXIST);
			} 	
		} catch (Exception e) {
			LOGGER.error("Encountered an exception while getting user list : " + e);
			return ResponseMessage.ErrorMessages.COMMON_ERROR;
		}
		return ResponseGenerator.successResponse(uRL);
		
	}

}
