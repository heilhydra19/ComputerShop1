package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.DTO.UsersDTOMapper;

@Repository
public class UsersDAO extends BaseDAO {
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT a.*, b.name, b.img, b.phone, b.email, b.id_role, c.name as role_name ");
		sql.append("FROM `accounts` a, `users` b, `roles` c ");
		sql.append("WHERE a.id_user = b.id AND c.id = b.id_role ");
		return sql;
	}

	public List<UsersDTO> GetDataUsers() {
		StringBuffer sql = SqlString();
		sql.append("GROUP BY a.id DESC");
		return _jdbcTemplate.query(sql.toString(), new UsersDTOMapper());
	}

	private String SqlUsersPaginate(String keyword, int start, int totalPage) {
		StringBuffer sql = SqlString();
		if (keyword != null) {
			sql.append("and id like '%" + keyword + "%' or name like '%" + keyword + "%' or username like '%" + keyword
					+ "%' or phone like '%" + keyword + "%'" + "or email like '%" + keyword + "%' or id_user like '%"
					+ keyword + "%'");
		}
		sql.append(" GROUP BY a.id DESC LIMIT " + (start - 1) + ", " + totalPage);
		return sql.toString();
	}

	public List<UsersDTO> GetDataUsersPaginate(String keyword, int start, int totalPage) {
		StringBuffer sqlGetData = SqlString();
		List<UsersDTO> listUsers = _jdbcTemplate.query(sqlGetData.toString(), new UsersDTOMapper());
		List<UsersDTO> listUsersPaginate = new ArrayList<UsersDTO>();
		if (listUsers.size() > 0) {
			String sql = SqlUsersPaginate(keyword, start, totalPage);
			listUsersPaginate = _jdbcTemplate.query(sql, new UsersDTOMapper());
		}
		return listUsersPaginate;
	}

	public List<UsersDTO> SearchUser(String keyword) {
		StringBuffer sql = SqlString();
		sql.append("and id like '%" + keyword + "%' or name like '%" + keyword + "%' or username like '%" + keyword
				+ "%' or phone like '%" + keyword + "%'" + "or email like '%" + keyword + "%' or id_user like '%"
				+ keyword + "%' GROUP BY a.id DESC ");
		return _jdbcTemplate.query(sql.toString(), new UsersDTOMapper());
	}

	public UsersDTO CheckAccount(UsersDTO account) {
		StringBuffer sql = SqlString();
		sql.append("AND BINARY a.username = BINARY '" + account.getUsername() + "' ");
		return _jdbcTemplate.queryForObject(sql.toString(), new UsersDTOMapper());
	}

	public int AddUser(UsersDTO user) {
		String sqlUser = "INSERT INTO `users`(`name`, `img`, `phone`, `email`, `id_role`) " + "VALUES (N'"
				+ user.getName() + "','" + user.getImg() + "','" + user.getPhone() + "','" + user.getEmail() + "','"
				+ user.getId_role() + "')";
		return _jdbcTemplate.update(sqlUser);
	}

	public int UpdateUser(UsersDTO user) {
		String sqlUser = "UPDATE `users` SET `name`=CASE WHEN '" + user.getName() + "'= '' THEN `name` ELSE N'"
				+ user.getName() + "' END,\r\n" + "				   `img`=CASE WHEN '" + user.getImg()
				+ "'= '' THEN `img` ELSE '" + user.getImg() + "' END,\r\n" + "                   `phone`=CASE WHEN '"
				+ user.getPhone() + "'= '' THEN `phone` ELSE '" + user.getPhone() + "' END,\r\n"
				+ "                   `email`=CASE WHEN '" + user.getEmail() + "'= '' THEN `email` ELSE '"
				+ user.getEmail() + "' END,\r\n" + "                   `id_role`=CASE WHEN '" + user.getId_role()
				+ "'= '' THEN `id_role` ELSE '" + user.getId_role() + "' END \r\n" + "                   WHERE `id`='"
				+ user.getId() + "'";
		return _jdbcTemplate.update(sqlUser);
	}

	public int DeleteUser(long id) {
		String sqlUser = "DELETE FROM `users` WHERE `id` = '" + id + "'";
		return _jdbcTemplate.update(sqlUser);
	}

	private long GetLastestIDUser() {
		String sql = "SELECT `id` FROM `users` ORDER BY `id` DESC LIMIT 1";
		return _jdbcTemplate.queryForObject(sql, Long.class);
	}

	private String GetLastestEmail() {
		String sql = "SELECT `email` FROM `users` ORDER BY `id` DESC LIMIT 1";
		return _jdbcTemplate.queryForObject(sql, String.class);
	}

	public int AddAccount(UsersDTO user) {
		String sqlAccount = "INSERT INTO `accounts`(`username`, `password`, `id_user`) " + "VALUES ('"
				+ user.getUsername() + "','" + user.getPassword() + "','" + GetLastestIDUser() + "')";
		return _jdbcTemplate.update(sqlAccount);
	}

	public int UpdateAccount(UsersDTO user) {
		String sqlAccount = "UPDATE `accounts` SET `username`=CASE WHEN '" + user.getUsername()
				+ "' = '' THEN `username` ELSE '" + user.getUsername() + "' END,\r\n"
				+ "					  `password`=CASE WHEN '" + user.getPassword() + "' = '' THEN `password` ELSE '"
				+ user.getPassword() + "' END \r\n" + "                      WHERE `id_user`='" + user.getId_user()
				+ "'";
		return _jdbcTemplate.update(sqlAccount);
	}

	public int DeleteAccount(long id) {
		String sqlAccount = "DELETE FROM `accounts` WHERE `id` = '" + id + "'";
		return _jdbcTemplate.update(sqlAccount);
	}

	public int AddCustomer(UsersDTO user) {
		String sqlUser = "INSERT INTO `users`(`name`, `img`, `phone`, `email`, `id_role`) " + "VALUES (N'"
				+ user.getName() + "','" + user.getImg() + "','" + user.getPhone() + "','" + user.getEmail() + "','3')";
		_jdbcTemplate.update(sqlUser);
		String sqlAccount = "INSERT INTO `accounts`(`username`, `password`, `id_user`) " + "VALUES ('"
				+ GetLastestEmail() + "','" + user.getPassword() + "','" + GetLastestIDUser() + "')";
		return _jdbcTemplate.update(sqlAccount);
	}
}