package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.ProductsDTO;
import ComputerShop1.DTO.ProductsDTOMapper;

@Repository
public class ProductsDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT a.*, b.url as url_img FROM `products` a, `img` b");
		sql.append(" WHERE a.id_img = b.id");
		return sql;
	}
	
	public List<ProductsDTO> GetDataNewProducts() {
		StringBuffer sql = SqlString();
		sql.append(" LIMIT 9");
		List<ProductsDTO> list = _jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		return list;
	}
	
	public List<ProductsDTO> GetDataProducts() {
		StringBuffer sql = SqlString();
		List<ProductsDTO> list = _jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		return list;
	}
	
	public List<ProductsDTO> GetProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append(" and a.id = "+ id);
		List<ProductsDTO> list = _jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
		return list;
	}
}
