package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.Brands;
import ComputerShop1.Entity.MapperBrands;

@Repository
public class BrandsDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM brands WHERE 1 ");
		return sql;
	}
	
	public List<Brands> GetDataBrands(){
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new MapperBrands());
	} 
	
	private String SqlBrandsPaginate(String keyword, int start, int totalPage) {
		StringBuffer sql = SqlString();
		if(keyword != null) {
			sql.append("and id like '%" + keyword + "%' or name like '%" + keyword + "%' ");
		}
		sql.append(" LIMIT " + (start - 1) + ", " + totalPage);
		return sql.toString();
	}

	public List<Brands> GetDataBrandsPaginate(String keyword, int start, int totalPage) {
		StringBuffer sqlGetData = SqlString();
		List<Brands> listBrands = _jdbcTemplate.query(sqlGetData.toString(), new MapperBrands());
		List<Brands> listBrandsPaginate = new ArrayList<Brands>();
		if (listBrands.size() > 0) {
			String sql = SqlBrandsPaginate(keyword, start, totalPage);
			listBrandsPaginate = _jdbcTemplate.query(sql, new MapperBrands());
		}
		return listBrandsPaginate;
	}
	
	public List<Brands> SearchBrand(String keyword){
		StringBuffer sql = SqlString();
		sql.append("AND id like '%"+keyword+"%' OR name like '%"+keyword+"%'");
		return _jdbcTemplate.query(sql.toString(), new MapperBrands());
	} 
	
	public int AddBrand(Brands brand) {
		String sql = "INSERT INTO `brands`(`name`, `description`) "
				+ "VALUES (N'"+brand.getName()+"',N'"+brand.getDescription()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateBrand(Brands brand) {
		String sql = "UPDATE `brands` SET `name`= CASE WHEN '"+brand.getName()+"' = '' THEN `name` ELSE N'"+brand.getName()+"' END,\r\n"
				+ "        `description`=CASE WHEN '"+brand.getDescription()+"' = '' THEN `description` ELSE N'"+brand.getDescription()+"' END \r\n"
				+ "        WHERE `id`='"+brand.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteBrand(long id) {
		String sql = "DELETE FROM `brands` WHERE `id` = '"+id+"'";
		return _jdbcTemplate.update(sql);
	}
}
