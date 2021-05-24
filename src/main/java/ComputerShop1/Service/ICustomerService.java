package ComputerShop1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ComputerShop1.DTO.CustomersDTO;

@Service
public interface ICustomerService {
	public List<CustomersDTO> GetDataCustomers();
	public int AddCustomer(CustomersDTO customer);
	public int UpdateCustomer(CustomersDTO customer);
	public int DeleteCustomer(long id);
}
