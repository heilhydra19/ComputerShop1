package ComputerShop1.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductsDTOMapper implements RowMapper<ProductsDTO>{

	public ProductsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDTO productsDTO = new ProductsDTO();
		productsDTO.setId(rs.getLong("id"));
		productsDTO.setId_category(rs.getLong("id_category"));
		productsDTO.setId_brand(rs.getLong("id_brand"));
		productsDTO.setName(rs.getNString("name"));
		productsDTO.setCategory(rs.getNString("category"));
		productsDTO.setBrand(rs.getNString("brand"));
		productsDTO.setAmount(rs.getInt("amount"));
		productsDTO.setPrice(rs.getDouble("price"));
		productsDTO.setDetail(rs.getNString("detail"));
		productsDTO.setCreated_at(rs.getDate("created_at"));
		productsDTO.setUpdated_at(rs.getDate("updated_at"));
		productsDTO.setImg(rs.getString("img"));
		return productsDTO;
	}

}
