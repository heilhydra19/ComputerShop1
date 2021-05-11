package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.CustomersDTO;
import ComputerShop1.DTO.CustomersDTOMapper;

@Repository
public class CustomersDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM `users` WHERE `id_role` = '3' ");
		return sql;
	}
	
	public List<CustomersDTO> GetDataCustomers() {
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new CustomersDTOMapper());
	}
	
	public int AddCustomer(CustomersDTO customer) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO `users`(`name`, `img`, `phone`, `email`, `id_role`) "
				+ "VALUES ('"+customer.getName()+"','"+customer.getImg()+"','"+customer.getPhone()+"','"+customer.getEmail()+"','3')");
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int UpdateCustomer(CustomersDTO customer) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE `users` SET `name`='"+customer.getName()+"',`img`='"+customer.getImg()+"',"
				+ "`phone`='"+customer.getPhone()+"',`email`='"+customer.getEmail()+"' WHERE `id` = '"+customer.getId()+"'");
		return _jdbcTemplate.update(sql.toString());
	}
	
	public int DeleteCustomer(CustomersDTO customer) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM `users` WHERE `id` = '"+customer.getId()+"'");
		return _jdbcTemplate.update(sql.toString());
	}
}
