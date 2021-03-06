package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.CustomersDAO;
import ComputerShop1.DTO.CustomersDTO;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomersDAO customersDAO;
	
	public List<CustomersDTO> GetDataCustomers() {
		return customersDAO.GetDataCustomers();
	}
	
	public List<CustomersDTO> GetDataCustomersPaginate(String keyword, int start, int totalPage){
		return customersDAO.GetDataCustomersPaginate(keyword, start, totalPage);
	}

	public int AddCustomer(CustomersDTO customer) {
		return customersDAO.AddCustomer(customer);
	}

	public int UpdateCustomer(CustomersDTO customer) {
		return customersDAO.UpdateCustomer(customer);
	}

	public int DeleteCustomer(long id) {
		return customersDAO.DeleteCustomer(id);
	}

	public List<CustomersDTO> SearchCustomer(String keyword) {
		return customersDAO.SearchCustomer(keyword);
	}

}
