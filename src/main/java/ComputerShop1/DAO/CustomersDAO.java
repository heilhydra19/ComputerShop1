package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.CustomersDTO;
import ComputerShop1.DTO.CustomersDTOMapper;

@Repository
public class CustomersDAO extends BaseDAO {
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM `users` WHERE `id_role` = '3' ");
		return sql;
	}

	public List<CustomersDTO> GetDataCustomers() {
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new CustomersDTOMapper());
	}

	private String SqlCustomersPaginate(String keyword, int start, int totalPage) {
		StringBuffer sql = SqlString();
		if (keyword != null) {
			sql.append("and id like '%" + keyword + "%' or name like '%" + keyword + "%' or phone like '%" + keyword
					+ "%' or email like '%" + keyword + "%' ");
		}
		sql.append(" LIMIT " + (start - 1) + ", " + totalPage);
		return sql.toString();
	}

	public List<CustomersDTO> GetDataCustomersPaginate(String keyword, int start, int totalPage) {
		StringBuffer sqlGetData = SqlString();
		List<CustomersDTO> listCustomers = _jdbcTemplate.query(sqlGetData.toString(), new CustomersDTOMapper());
		List<CustomersDTO> listCustomersPaginate = new ArrayList<CustomersDTO>();
		if (listCustomers.size() > 0) {
			String sql = SqlCustomersPaginate(keyword, start, totalPage);
			listCustomersPaginate = _jdbcTemplate.query(sql, new CustomersDTOMapper());
		}
		return listCustomersPaginate;
	}

	public List<CustomersDTO> SearchCustomer(String keyword) {
		StringBuffer sql = SqlString();
		sql.append("and id like '%" + keyword + "%' or name like '%" + keyword + "%' or phone like '%" + keyword
				+ "%' or email like '%" + keyword + "%' ");
		return _jdbcTemplate.query(sql.toString(), new CustomersDTOMapper());
	}

	public int AddCustomer(CustomersDTO customer) {
		String sql = "INSERT INTO `users`(`name`, `img`, `phone`, `email`, `id_role`) " + "VALUES (N'"
				+ customer.getName() + "','" + customer.getImg() + "','" + customer.getPhone() + "','"
				+ customer.getEmail() + "','3')";
		return _jdbcTemplate.update(sql);
	}

	public int UpdateCustomer(CustomersDTO customer) {
		String sql = "UPDATE `users` SET `name`=CASE WHEN '" + customer.getName() + "' = '' THEN `name` ELSE N'"
				+ customer.getName() + "' END,\r\n" + "		`img`=CASE WHEN '" + customer.getImg()
				+ "' = '' THEN `img` ELSE '" + customer.getImg() + "' END,\r\n" + "		`phone`=CASE WHEN '"
				+ customer.getPhone() + "' = '' THEN `phone` ELSE '" + customer.getPhone() + "' END,\r\n"
				+ "        `email`=CASE WHEN '" + customer.getEmail() + "' = '' THEN `email` ELSE '"
				+ customer.getEmail() + "' END \r\n" + "        WHERE `id` = '" + customer.getId() + "'";
		return _jdbcTemplate.update(sql);
	}

	public int DeleteCustomer(long id) {
		String sql = "DELETE FROM `users` WHERE `id` = '" + id + "'";
		return _jdbcTemplate.update(sql);
	}
}
