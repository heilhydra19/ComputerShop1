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
}
