package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import ComputerShop1.Entity.MapperSuppliers;
import ComputerShop1.Entity.Suppliers;

@Repository
public class SuppliersDAO extends BaseDAO{
	public List<Suppliers> GetDataSuppliers(){
		List<Suppliers> list = new ArrayList<Suppliers>();
		String sql = "SELECT * FROM suppliers";
		list = _jdbcTemplate.query(sql, new MapperSuppliers());
		return list;
	} 
	
	public int AddSupplier(Suppliers supplier) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `suppliers`(`name`, `phone`, `email`, `img`) "
				+ "VALUES ('"+supplier.getName()+"','"+supplier.getPhone()+"','"+supplier.getEmail()+"','"+supplier.getImg()+"') ");
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int UpdateSupplier(Suppliers supplier) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE `suppliers` SET `name`='"+supplier.getName()+"',`phone`='"+supplier.getPhone()+"',"
				+ "`email`='"+supplier.getEmail()+"',`img`='"+supplier.getImg()+"' WHERE `id` ='"+supplier.getId()+"'");
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int DeleteSupplier(Suppliers supplier) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM `suppliers` WHERE `id` = '"+supplier.getId()+"'");
		return _jdbcTemplate.update(sql.toString());
	}
}
