package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.ProductsDAO;
import ComputerShop1.DTO.ProductsDTO;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	ProductsDAO productsDAO;
	
	public ProductsDTO GetProductByID(long id) {
		return productsDAO.GetProductByID(id);
	}

	public List<ProductsDTO> GetProductByIDCategory(long id) {
		return productsDAO.GetProductByIDCategory(id);
	}
	
	public List<ProductsDTO> GetDataProducts() {
		return productsDAO.GetDataProducts();
	}

	public int AddProduct(ProductsDTO product) {
		return productsDAO.AddProduct(product);
	}
	
	public int UpdateProduct(ProductsDTO product) {
		return productsDAO.UpdateProduct(product);
	}

	public int DeleteProduct(long id) {
		return productsDAO.DeleteProduct(id);
	}

	public List<ProductsDTO> SearchProduct(String keyword) {
		return productsDAO.SearchProduct(keyword);
	}
}
