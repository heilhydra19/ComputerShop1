package ComputerShop1.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperSuppliers implements RowMapper<Suppliers>{
	public Suppliers mapRow(ResultSet rs, int rowNum) throws SQLException {
		Suppliers suppliers = new Suppliers();
		suppliers.setId(rs.getLong("id"));
		suppliers.setName(rs.getString("name"));
		suppliers.setPhone(rs.getString("phone"));
		suppliers.setEmail(rs.getString("email"));
		suppliers.setImg(rs.getString("img"));
		return suppliers;
	}
}
