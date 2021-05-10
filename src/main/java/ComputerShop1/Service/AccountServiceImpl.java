package ComputerShop1.Service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.AccountDAO;
import ComputerShop1.DTO.AccountsDTO;

@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	private AccountDAO accountDAO;
	public AccountsDTO FindAccountByUsername(AccountsDTO account) {
		return accountDAO.FindAccountByUsername(account);
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
}
