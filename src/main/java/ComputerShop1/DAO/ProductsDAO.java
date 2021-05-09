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
		sql.append(" SELECT a.*, b.name category, c.name brand ");
		sql.append(" FROM `products` a, `categories` b, `brands` c ");
		sql.append(" WHERE a.id_category = b.id AND a.id_brand = c.id ");
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
		sql.append(" order by a.id");
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
	
	public ProductsDTO FindProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append(" and a.id = " + id);
		return _jdbcTemplate.queryForObject(sql.toString(), new ProductsDTOMapper());
	}
	
	public int AddProduct(ProductsDTO product) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `products`(`id_category`, `id_brand`, `img`, `name`, `amount`, `price`, `detail`) ");
		sql.append("VALUES ('"+product.getId_category()+"','"+product.getId_brand()+"','"+product.getImg()+"','"+product.getName()+"','0' ,'"+product.getPrice()+"','"+product.getDetail()+"')");
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int UpdateProduct(ProductsDTO product) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE `products` SET `id_category`='"+product.getId_category()+"',`id_brand`='"+product.getId_brand()+"',`name`='"+product.getName()+"',`img`='"+product.getImg()+"',`amount`=amount,`price`='"+product.getPrice()+"',`detail`='"+product.getDetail()+"', ");
		sql.append("`created_at`=created_at, `updated_at`=CURRENT_TIMESTAMP WHERE id = " + product.getId());
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int DeleteProduct(ProductsDTO product) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM `products` WHERE id = "+ product.getId());
		return _jdbcTemplate.update(sql.toString());
	}
}
