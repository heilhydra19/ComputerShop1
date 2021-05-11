package ComputerShop1.DAO;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.DTO.UsersDTOMapper;

@Repository
public class UsersDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.*, b.name, b.phone, b.email, b.id_role, c.name as role_name ");
		sql.append("FROM `accounts` a, `users` b, `roles` c ");
		sql.append("WHERE a.id_user = b.id AND c.id = b.id_role ");
		return sql;
	}
	
	public UsersDTO FindAccountByUsername(UsersDTO account) {
		StringBuffer sql = SqlString();
		sql.append("AND BINARY a.username = '"+account.getUsername()+"' AND BINARY a.password='"+account.getPassword()+"' ");
		return _jdbcTemplate.queryForObject(sql.toString(), new UsersDTOMapper());
	}
	
	public int AddUser(UsersDTO user) {
		StringBuffer sql = SqlString();
		
	}
}