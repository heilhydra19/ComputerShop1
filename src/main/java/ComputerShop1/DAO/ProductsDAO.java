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
		sql.append("SELECT c.*, (SUM(c.nhap) - SUM(c.xuat)) amount, d.name category, e.name brand FROM ");
		sql.append("(SELECT b.*, 0 nhap, SUM(a.amount) xuat FROM `billdetails` a, `products` b WHERE a.id_product = b.id ");
		sql.append("GROUP BY b.id ");
		sql.append("UNION ");
		sql.append("SELECT b.*, SUM(a.amount) nhap, 0 xuat FROM `importdetails` a, `products` b WHERE a.id_product = b.id ");
		sql.append("GROUP BY b.id ");
		sql.append("UNION ");
		sql.append("SELECT *, 0 nhap, 0 xuat FROM `products`) c, `categories` d, `brands` e ");
		sql.append("WHERE c.id_category = d.id AND c.id_brand = e.id ");
		sql.append("GROUP BY c.id ");
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
		sql.append(" order by c.id DESC");
		return _jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
	}
	
	public ProductsDTO GetProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append(" and c.id = "+ id);
		return _jdbcTemplate.queryForObject(sql.toString(), new ProductsDTOMapper());
	}

	private StringBuffer SqlProductsByIDCategory(long id) {
		StringBuffer sql = SqlString();
		sql.append(" AND c.id_category = " + id);
		return sql;
	}

	public List<ProductsDTO> GetProductByIDCategory(long id) {
		StringBuffer sql = SqlProductsByIDCategory(id);
		return _jdbcTemplate.query(sql.toString(), new ProductsDTOMapper());
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
		sql.append(" and c.id = " + id);
		return _jdbcTemplate.queryForObject(sql.toString(), new ProductsDTOMapper());
	}
	
	public int AddProduct(ProductsDTO product) {
		String sql = "INSERT INTO `products`(`id_category`, `id_brand`, `img`, `name`, `price`, `detail`) "
				+ "VALUES ('"+product.getId_category()+"','"+product.getId_brand()+"','"+product.getImg()+"','"+product.getName()+"','"+product.getPrice()+"','"+product.getDetail()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateProduct(ProductsDTO product) {
		String sql = "UPDATE `products` SET `id_category`=CASE WHEN '"+product.getId_category()+"' = '' THEN `id_category` ELSE '"+product.getId_category()+"' END,\r\n"
				+ "		`id_brand`=CASE WHEN '"+product.getId_brand()+"' = '' THEN `id_brand` ELSE '"+product.getId_brand()+"' END,\r\n"
				+ "        `name`=CASE WHEN '"+product.getName()+"' = '' THEN `name` ELSE '"+product.getName()+"' END,\r\n"
				+ "        `img`=CASE WHEN '"+product.getImg()+"' = '' THEN `img` ELSE '"+product.getImg()+"' END,\r\n"
				+ "        `price`=CASE WHEN '"+product.getPrice()+"' = '' THEN `price` ELSE '"+product.getPrice()+"' END,\r\n"
				+ "        `detail`=CASE WHEN '"+product.getDetail()+"' = '' THEN `detail` ELSE '"+product.getDetail()+"' END,\r\n"
				+ "        `created_at`=created_at,`updated_at`=CURRENT_TIMESTAMP \r\n"
				+ "        WHERE `id`='"+product.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteProduct(ProductsDTO product) {
		String sql = "DELETE FROM `products` WHERE id = "+ product.getId();
		return _jdbcTemplate.update(sql);
	}
}
