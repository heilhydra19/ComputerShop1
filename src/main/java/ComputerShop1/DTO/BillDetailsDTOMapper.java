package ComputerShop1.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BillDetailsDTOMapper implements RowMapper<BillDetailsDTO>{

	public BillDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BillDetailsDTO billDetails = new BillDetailsDTO();
		billDetails.setId(rs.getLong("id"));
		billDetails.setId_bill(rs.getLong("id_bill"));
		billDetails.setId_product(rs.getLong("id_product"));
		billDetails.setProduct(rs.getString("product"));
		billDetails.setAmount(rs.getInt("amount"));
		billDetails.setPrice(rs.getDouble("price"));
		billDetails.setSellprice(rs.getDouble("sellprice"));
		return billDetails;
	}
	
}
