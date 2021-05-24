package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.MapperMenu;
import ComputerShop1.Entity.Menu;

@Repository
public class MenuDAO extends BaseDAO{
	public List<Menu> GetDataMenu(){
		List<Menu> list = new ArrayList<Menu>();
		String sql = "SELECT * FROM menu";
		list = _jdbcTemplate.query(sql, new MapperMenu());
		return list;
	} 
}
