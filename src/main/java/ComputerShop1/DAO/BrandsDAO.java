package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.Brands;
import ComputerShop1.Entity.MapperBrands;

@Repository
public class BrandsDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM brands ");
		return sql;
	}
	
	public List<Brands> GetDataBrands(){
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new MapperBrands());
	} 
	
	public int AddBrand(Brands brand) {
		String sql = "INSERT INTO `brands`(`name`, `description`) "
				+ "VALUES ('"+brand.getName()+"','"+brand.getDescription()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateBrand(Brands brand) {
		String sql = "UPDATE `brands` SET `name`= CASE WHEN '"+brand.getName()+"' = '' THEN `name` ELSE '"+brand.getName()+"' END,\r\n"
				+ "        `description`=CASE WHEN '"+brand.getDescription()+"' = '' THEN `description` ELSE '"+brand.getDescription()+"' END \r\n"
				+ "        WHERE `id`='"+brand.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteBrand(Brands brand) {
		String sql = "DELETE FROM `brands` WHERE `id` = '"+brand.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
}
