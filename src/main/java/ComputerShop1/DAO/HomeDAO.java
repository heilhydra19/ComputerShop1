package ComputerShop1.DAO;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.MapperSlides;
import ComputerShop1.Entity.Slides;

@Repository
public class HomeDAO extends BaseDAO{
	public List<Slides> GetDataSlide(){
		List<Slides> list = new ArrayList<Slides>();
		String sql = "SELECT * FROM slides";
		list = _jdbcTemplate.query(sql, new MapperSlides());
		return list;
	} 
}