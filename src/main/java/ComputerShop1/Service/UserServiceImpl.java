package ComputerShop1.Service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.RolesDAO;
import ComputerShop1.DAO.UsersDAO;
import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.Entity.Roles;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private RolesDAO rolesDAO;
	public UsersDTO FindAccountByUsername(UsersDTO account) {
		return usersDAO.FindAccountByUsername(account);
//		String pass = account.getPassword();
//		account = accountDAO.FindAccountByUsername(account);
//		if(account != null) {
//			if(BCrypt.checkpw(pass, account.getPassword())) {
//				return account;
//			}
//			else {
//				return null;
//			}
//		}
//		return null;
	}
	public List<Roles> GetDataRoles() {
		return rolesDAO.GetDataRoles();
	}
	public List<UsersDTO> GetDataUsers() {
		return usersDAO.GetDataUsers();
	}
	public int AddUser(UsersDTO user) {
		return usersDAO.AddUser(user);
	}
	public int UpdateUser(UsersDTO user) {
		return usersDAO.UpdateUser(user);
	}
	public int DeleteUser(UsersDTO user) {
		return usersDAO.DeleteUser(user);
	}
	public int AddAccount(UsersDTO user) {
		return usersDAO.AddAccount(user);
	}
	public int UpdateAccount(UsersDTO user) {
		return usersDAO.UpdateAccount(user);
	}
	public int DeleteAccount(UsersDTO user) {
		return usersDAO.DeleteAccount(user);
	}
}
