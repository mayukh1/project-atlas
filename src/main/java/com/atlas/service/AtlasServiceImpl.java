package com.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atlas.dao.AtlasDao;
import com.atlas.dto.Url;
@Service(value = "atlasService")
public class AtlasServiceImpl implements AtlasService {
	@Autowired
	private  AtlasDao dao;

	@Override
	public Url getUrl(String searchParam, String searchParam1) {
		return dao.getUrl(searchParam, searchParam1);
	}

}
