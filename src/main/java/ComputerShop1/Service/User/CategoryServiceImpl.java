package ComputerShop1.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.ProductsDAO;
import ComputerShop1.DTO.ProductsDTO;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ProductsDAO productsDAO;

	public List<ProductsDTO> GetProductByIDCategory(long id) {
		return productsDAO.GetProductByIDCategory(id);
	}

	public List<ProductsDTO> GetDataProductsPaginate(long id, int start, int totalPage) {
		return productsDAO.GetDataProductsPaginate(id, start, totalPage);
	}
}
