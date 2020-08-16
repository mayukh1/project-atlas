package com.atlas.dao;
import javax.sql.DataSource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.atlas.dto.Url;
import com.atlas.mapper.SqlDataMapper;
import com.atlas.util.Sql_demo;

@Repository(value = "dao")
public class AtlasDaoImpl implements AtlasDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	SqlDataMapper mapper;
	@Autowired
	DataSource dataSource;

	@Override
	public Url getUrl(String searchParam, String searchParam1) {
		final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(AtlasDaoImpl.class);
		Url uRl=null;
		try {
			uRl=jdbcTemplate.query(Sql_demo.entertainment.GET_URL, new Object[] { searchParam, searchParam1 },
					mapper.new url()).get(0);
			
		} catch (Exception e) {
			LOGGER.error("Encountered an exception while fetching all roles" + e);
		}
		return uRl;
	}

}
