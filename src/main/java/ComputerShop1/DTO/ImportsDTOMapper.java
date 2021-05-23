package ComputerShop1.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ImportsDTOMapper implements RowMapper<ImportsDTO>{

	public ImportsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ImportsDTO imports = new ImportsDTO();
		imports.setId(rs.getLong("id"));
		imports.setId_supplier(rs.getLong("id_supplier"));
		imports.setSupplier(rs.getNString("name"));
		imports.setCreated_at(rs.getDate("created_at"));
		return imports;
	}
	
}
