package com.atlas.mapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.atlas.dto.Url;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class SqlDataMapper {
	public class url implements RowMapper<Url> {
		public Url mapRow(ResultSet rs, int rowNum) throws SQLException {
			Url url= new Url();
			url.setUrl(rs.getString("bu_url"));
			return url;
		}
	}
}
