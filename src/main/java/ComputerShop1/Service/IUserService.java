package ComputerShop1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.Entity.Roles;

@Service
public interface IUserService {
	public List<Roles> GetDataRoles();
	public List<UsersDTO> GetDataUsers();
	public UsersDTO CheckAccount(UsersDTO account);
	public int AddUser(UsersDTO user);
	public int UpdateUser(UsersDTO user);
	public int DeleteUser(long id);
	public int AddAccount(UsersDTO user);
	public int UpdateAccount(UsersDTO user);
	public int DeleteAccount(long id);
	public int AddCustomer(UsersDTO user);
}
