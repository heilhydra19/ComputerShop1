package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.Brands;
import ComputerShop1.Entity.MapperBrands;

@Repository
public class BrandsDAO extends BaseDAO{
	public List<Brands> GetDataBrands(){
		List<Brands> list = new ArrayList<Brands>();
		String sql = "SELECT * FROM brands";
		list = _jdbcTemplate.query(sql, new MapperBrands());
		return list;
	} 
	
	public int AddBrand(Brands brand) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `brands`(`name`, `description`) ");
		sql.append("VALUES ('"+brand.getName()+"','"+brand.getDescription()+"')");
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int UpdateBrand(Brands brand) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE `brands` SET `name`='"+brand.getName()+"',`description`='"+brand.getDescription()+"' WHERE `id`= '"+brand.getId()+"'");
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int DeleteBrand(Brands brand) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM `brands` WHERE `id` = '"+brand.getId()+"'");
		return _jdbcTemplate.update(sql.toString());
	}
}
