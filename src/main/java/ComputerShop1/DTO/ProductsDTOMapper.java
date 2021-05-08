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
		productsDTO.setId_img(rs.getLong("id_img"));
		productsDTO.setName(rs.getString("name"));
		productsDTO.setCategory(rs.getString("category"));
		productsDTO.setBrand(rs.getString("brand"));
		productsDTO.setAmount(rs.getInt("amount"));
		productsDTO.setPrice(rs.getDouble("price"));
		productsDTO.setDetail(rs.getString("detail"));
		productsDTO.setCreated_at(rs.getDate("created_at"));
		productsDTO.setUpdated_at(rs.getDate("updated_at"));
		productsDTO.setUrl_img(rs.getString("url_img"));
		return productsDTO;
	}

}
