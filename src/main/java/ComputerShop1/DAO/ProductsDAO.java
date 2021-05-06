package ComputerShop1.DAO;

import java.util.ArrayList;
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
		sql.append(" LIMIT 12");
		return _jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
	}
	
	public List<ProductsDTO> GetDataHomeProducts() {
		StringBuffer sql = SqlString();
		sql.append(" LIMIT 12");
		return _jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
	}
	
	public List<ProductsDTO> GetDataProducts() {
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
	}
	
	public ProductsDTO GetProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append(" and a.id = "+ id);
		return _jdbcTemplate.queryForObject(sql.toString(), new ProductsDTOMapper());
	}

	public List<ProductsDTO> GetProductByIDCategory(long id) {
		StringBuffer sql = SqlProductsByIDCategory(id);
		return _jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
	}

	private StringBuffer SqlProductsByIDCategory(long id) {
		StringBuffer sql = SqlString();
		sql.append(" AND id_category = " + id);
		return sql;
	}
	
	private String SqlProductsPaginate(long id, int start, int totalPage) {
		StringBuffer sql = SqlProductsByIDCategory(id);
		sql.append(" LIMIT " + start + ", "+ totalPage);
		return sql.toString();
	}
	
	public List<ProductsDTO> GetDataProductsPaginate(long id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductsByIDCategory(id);
		List<ProductsDTO> listProductsByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new ProductsDTOMapper());
		List<ProductsDTO> listProducts = new ArrayList<ProductsDTO>();
		if(listProductsByID.size() > 0) {
			String sql = SqlProductsPaginate(id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		}
		return listProducts;
	}
}
