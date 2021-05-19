package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.DTO.UsersDTOMapper;

@Repository
public class UsersDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.*, b.name, b.img, b.phone, b.email, b.id_role, c.name as role_name ");
		sql.append("FROM `accounts` a, `users` b, `roles` c ");
		sql.append("WHERE a.id_user = b.id AND c.id = b.id_role ");
		return sql;
	}
	
	public List<UsersDTO> GetDataUsers() {
		StringBuffer sql = SqlString();
		sql.append("GROUP BY a.id ");
		return _jdbcTemplate.query(sql.toString(), new UsersDTOMapper());
	}
	
	public UsersDTO FindAccountByUsername(UsersDTO account) {
		StringBuffer sql = SqlString();
		sql.append("AND a.username = '"+account.getUsername()+"' AND a.password='"+account.getPassword()+"' ");
		return _jdbcTemplate.queryForObject(sql.toString(), new UsersDTOMapper());
	}
	
	public int AddUser(UsersDTO user) {
		String sqlUser = "INSERT INTO `users`(`name`, `img`, `phone`, `email`, `id_role`) "
				+ "VALUES ('"+user.getName()+"','"+user.getImg()+"','"+user.getPhone()+"','"+user.getEmail()+"','"+user.getId_role()+"')";
		return _jdbcTemplate.update(sqlUser);
	}

	public int UpdateUser(UsersDTO user) {
		String sqlUser = "UPDATE `users` SET `name`=CASE WHEN '"+user.getName()+"'= '' THEN `name` ELSE '"+user.getName()+"' END,\r\n"
				+ "				   `img`=CASE WHEN '"+user.getImg()+"'= '' THEN `img` ELSE '"+user.getImg()+"' END,\r\n"
				+ "                   `phone`=CASE WHEN '"+user.getPhone()+"'= '' THEN `phone` ELSE '"+user.getPhone()+"' END,\r\n"
				+ "                   `email`=CASE WHEN '"+user.getEmail()+"'= '' THEN `email` ELSE '"+user.getEmail()+"' END,\r\n"
				+ "                   `id_role`=CASE WHEN '"+user.getId_role()+"'= '' THEN `id_role` ELSE '"+user.getId_role()+"' END \r\n"
				+ "                   WHERE `id`='"+user.getId()+"'";
		return _jdbcTemplate.update(sqlUser);
	}
	
	public int DeleteUser(UsersDTO user) {
		String sqlAccount = "DELETE FROM `accounts` WHERE `id_user` = '"+user.getId()+"'";
		_jdbcTemplate.update(sqlAccount);
		String sqlUser = "DELETE FROM `users` WHERE `id` = '"+user.getId()+"'";
		return _jdbcTemplate.update(sqlUser);
	}
	
	public int AddAccount(UsersDTO user) {
		String sqlAccount = "INSERT INTO `accounts`(`username`, `password`, `id_user`) "
				+ "VALUES ('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getId()+"')";
		return _jdbcTemplate.update(sqlAccount);
	}
	
	public int UpdateAccount(UsersDTO user) {
		String sqlAccount = "UPDATE `accounts` SET `username`=CASE WHEN '"+user.getUsername()+"' = '' THEN `username` ELSE '"+user.getUsername()+"' END,\r\n"
				+ "					  `password`=CASE WHEN '"+user.getPassword()+"' = '' THEN `password` ELSE '"+user.getPassword()+"' END \r\n"
				+ "                      WHERE `id_user`='"+user.getId_user()+"'";
		return _jdbcTemplate.update(sqlAccount);
	}
	
	public int DeleteAccount(UsersDTO user) {
		String sqlAccount = "DELETE FROM `accounts` WHERE `id_user` = '"+user.getId_user()+"'";
		return _jdbcTemplate.update(sqlAccount);
	}
}