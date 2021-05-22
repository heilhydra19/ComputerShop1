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
		String sql = "INSERT INTO `users`(`name`, `img`, `phone`, `email`, `id_role`) "
				+ "VALUES ('"+customer.getName()+"','"+customer.getImg()+"','"+customer.getPhone()+"','"+customer.getEmail()+"','3')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateCustomer(CustomersDTO customer) {
		String sql = "UPDATE `users` SET `name`=CASE WHEN '"+customer.getName()+"' = '' THEN `name` ELSE '"+customer.getName()+"' END,\r\n"
				+ "		`img`=CASE WHEN '"+customer.getImg()+"' = '' THEN `img` ELSE '"+customer.getImg()+"' END,\r\n"
				+ "		`phone`=CASE WHEN '"+customer.getPhone()+"' = '' THEN `phone` ELSE '"+customer.getPhone()+"' END,\r\n"
				+ "        `email`=CASE WHEN '"+customer.getEmail()+"' = '' THEN `email` ELSE '"+customer.getEmail()+"' END \r\n"
				+ "        WHERE `id` = '"+customer.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteCustomer(long id) {
		String sql = "DELETE FROM `users` WHERE `id` = '"+id+"'";
		return _jdbcTemplate.update(sql);
	}
}
