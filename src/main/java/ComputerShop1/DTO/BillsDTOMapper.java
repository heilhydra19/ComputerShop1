package ComputerShop1.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BillsDTOMapper implements RowMapper<BillsDTO>{

	public BillsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillsDTO bills = new BillsDTO();
		bills.setId(rs.getLong("id"));
		bills.setUser(rs.getNString("name"));
		bills.setAddress(rs.getNString("address"));
		bills.setId_user(rs.getLong("id_user"));
		bills.setCreated_at(rs.getDate("created_at"));
		return bills;
	}
	
}
