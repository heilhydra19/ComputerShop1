package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.Categories;
import ComputerShop1.Entity.MapperCategories;

@Repository
public class CategoriesDAO extends BaseDAO{
	public List<Categories> GetDataCategories(){
		List<Categories> list = new ArrayList<Categories>();
		String sql = "SELECT * FROM categories";
		list = _jdbcTemplate.query(sql, new MapperCategories());
		return list;
	} 
	
	public int AddCategory(Categories category) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `categories`(`name`, `description`) ");
		sql.append("VALUES ('"+category.getName()+"','"+category.getDescription()+"')");
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int UpdateCategory(Categories category) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE `categories` SET `name`='"+category.getName()+"',`description`='"+category.getDescription()+"'"
				+ " WHERE `id`= '"+category.getId()+"'");
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int DeleteCategory(Categories category) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM `categories` WHERE `id` = '"+category.getId()+"'");
		return _jdbcTemplate.update(sql.toString());
	}
}
