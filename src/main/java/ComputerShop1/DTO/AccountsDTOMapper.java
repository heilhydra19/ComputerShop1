package ComputerShop1.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountsDTOMapper implements RowMapper<AccountsDTO>{
	public AccountsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccountsDTO account = new AccountsDTO();
		account.setId(rs.getLong("id"));
		account.setUsername(rs.getString("username"));
		account.setPassword(rs.getString("password"));
		account.setId_user(rs.getLong("id_user"));
		account.setName(rs.getString("name"));
		account.setPhone(rs.getString("phone"));
		account.setEmail(rs.getString("email"));
		account.setId_role(rs.getLong("id_role"));
		account.setRole_name(rs.getString("role_name"));
		return account;
	}
}
