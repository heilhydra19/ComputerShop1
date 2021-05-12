package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.Categories;
import ComputerShop1.Entity.MapperCategories;

@Repository
public class CategoriesDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM categories ");
		return sql;
	}
	
	public List<Categories> GetDataCategories(){
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new MapperCategories());
	} 
	
	public int AddCategory(Categories category) {
		String sql = "INSERT INTO `categories`(`name`, `description`) VALUES ('"+category.getName()+"','"+category.getDescription()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateCategory(Categories category) {
		String sql = "UPDATE `categories` SET `name`= CASE WHEN '"+category.getName()+"' = '' THEN `name` ELSE '"+category.getName()+"' END,\r\n"
				+ "        `description`=CASE WHEN '"+category.getDescription()+"' = '' THEN `description` ELSE '"+category.getDescription()+"' END \r\n"
				+ "        WHERE `id`='"+category.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteCategory(Categories category) {
		String sql = "DELETE FROM `categories` WHERE `id` = '"+category.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
}
