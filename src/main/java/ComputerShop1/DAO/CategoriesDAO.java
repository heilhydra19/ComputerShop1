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
}
