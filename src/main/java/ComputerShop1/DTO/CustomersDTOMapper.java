package ComputerShop1.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomersDTOMapper implements RowMapper<CustomersDTO>{
	public CustomersDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CustomersDTO customersDTO = new CustomersDTO();
		customersDTO.setId(rs.getLong("id"));
		customersDTO.setName(rs.getNString("name"));
		customersDTO.setImg(rs.getString("img"));
		customersDTO.setPhone(rs.getString("phone"));
		customersDTO.setEmail(rs.getString("email"));
		return customersDTO;
	}
}
