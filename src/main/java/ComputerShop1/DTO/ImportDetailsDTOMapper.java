package ComputerShop1.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ImportDetailsDTOMapper implements RowMapper<ImportDetailsDTO>{

	public ImportDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ImportDetailsDTO importDetails = new ImportDetailsDTO();
		importDetails.setId(rs.getLong("id"));
		importDetails.setId_import(rs.getLong("id_import"));
		importDetails.setId_product(rs.getLong("id_product"));
		importDetails.setProduct(rs.getNString("product"));
		importDetails.setAmount(rs.getInt("amount"));
		importDetails.setPrice(rs.getDouble("price"));
		return importDetails;
	}

}
