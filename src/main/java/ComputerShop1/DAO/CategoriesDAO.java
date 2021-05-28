package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.Categories;
import ComputerShop1.Entity.MapperCategories;

@Repository
public class CategoriesDAO extends BaseDAO {
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM categories where 1 ");
		return sql;
	}

	public List<Categories> GetDataCategories() {
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new MapperCategories());
	}

	private String SqlCategoriesPaginate(String keyword, int start, int totalPage) {
		StringBuffer sql = SqlString();
		if(keyword != null) {
			sql.append("and id like '%" + keyword + "%' or name like '%" + keyword + "%' ");
		}
		sql.append(" LIMIT " + (start - 1) + ", " + totalPage);
		return sql.toString();
	}

	public List<Categories> GetDataCategoriesPaginate(String keyword, int start, int totalPage) {
		StringBuffer sqlGetData = SqlString();
		List<Categories> listCategories = _jdbcTemplate.query(sqlGetData.toString(), new MapperCategories());
		List<Categories> listCategoriesPaginate = new ArrayList<Categories>();
		if (listCategories.size() > 0) {
			String sql = SqlCategoriesPaginate(keyword, start, totalPage);
			listCategoriesPaginate = _jdbcTemplate.query(sql, new MapperCategories());
		}
		return listCategoriesPaginate;
	}

	public List<Categories> SearchCategory(String keyword) {
		StringBuffer sql = SqlString();
		sql.append("and id like '%" + keyword + "%' or name like '%" + keyword + "%' ");
		return _jdbcTemplate.query(sql.toString(), new MapperCategories());
	}

	public int AddCategory(Categories category) {
		String sql = "INSERT INTO `categories`(`name`, `description`) VALUES (N'" + category.getName() + "',N'"
				+ category.getDescription() + "')";
		return _jdbcTemplate.update(sql);
	}

	public int UpdateCategory(Categories category) {
		String sql = "UPDATE `categories` SET `name`= CASE WHEN '" + category.getName() + "' = '' THEN `name` ELSE N'"
				+ category.getName() + "' END,\r\n" + "        `description`=CASE WHEN '" + category.getDescription()
				+ "' = '' THEN `description` ELSE N'" + category.getDescription() + "' END \r\n"
				+ "        WHERE `id`='" + category.getId() + "'";
		return _jdbcTemplate.update(sql);
	}

	public int DeleteCategory(long id) {
		String sql = "DELETE FROM `categories` WHERE `id` = '" + id + "'";
		return _jdbcTemplate.update(sql);
	}
}
