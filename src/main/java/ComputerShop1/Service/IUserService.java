package ComputerShop1.Service;

import org.springframework.stereotype.Service;

import ComputerShop1.DTO.UsersDTO;

@Service
public interface IUserService {
	public UsersDTO FindAccountByUsername(UsersDTO account);
}
