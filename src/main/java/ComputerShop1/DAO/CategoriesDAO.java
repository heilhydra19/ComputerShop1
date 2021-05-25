package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.Categories;
import ComputerShop1.Entity.MapperCategories;

@Repository
public class CategoriesDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM categories where 1 ");
		return sql;
	}
	
	public List<Categories> GetDataCategories(){
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new MapperCategories());
	} 
	
	public List<Categories> SearchCategory(String keyword){
		StringBuffer sql = SqlString();
		sql.append("and id like '%"+keyword+"%' or name like '%"+keyword+"%' ");
		return _jdbcTemplate.query(sql.toString(), new MapperCategories());
	} 
	
	public int AddCategory(Categories category) {
		String sql = "INSERT INTO `categories`(`name`, `description`) VALUES (N'"+category.getName()+"',N'"+category.getDescription()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateCategory(Categories category) {
		String sql = "UPDATE `categories` SET `name`= CASE WHEN '"+category.getName()+"' = '' THEN `name` ELSE N'"+category.getName()+"' END,\r\n"
				+ "        `description`=CASE WHEN '"+category.getDescription()+"' = '' THEN `description` ELSE N'"+category.getDescription()+"' END \r\n"
				+ "        WHERE `id`='"+category.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteCategory(long id) {
		String sql = "DELETE FROM `categories` WHERE `id` = '"+id+"'";
		return _jdbcTemplate.update(sql);
	}
}
