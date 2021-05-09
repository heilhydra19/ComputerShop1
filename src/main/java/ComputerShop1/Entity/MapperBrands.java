package ComputerShop1.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperBrands implements RowMapper<Brands> {

	public Brands mapRow(ResultSet rs, int rowNum) throws SQLException {
		Brands brands = new Brands();
		brands.setId(rs.getLong("id"));
		brands.setName(rs.getString("name"));
		brands.setDescription(rs.getString("description"));
		return brands;
	}
}

