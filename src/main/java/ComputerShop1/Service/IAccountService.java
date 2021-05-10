package ComputerShop1.Service;

import org.springframework.stereotype.Service;

import ComputerShop1.DTO.AccountsDTO;

@Service
public interface IAccountService {
	public AccountsDTO FindAccountByUsername(AccountsDTO account);
}
