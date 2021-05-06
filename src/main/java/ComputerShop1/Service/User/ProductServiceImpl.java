package ComputerShop1.Service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.ProductsDAO;
import ComputerShop1.DTO.ProductsDTO;

@Service
public class ProductServiceImpl {
	@Autowired
	ProductsDAO productsDAO;
	
	public ProductsDTO GetProductByID(long id) {
		return productsDAO.GetProductByID(id).get(0);
	}
}
