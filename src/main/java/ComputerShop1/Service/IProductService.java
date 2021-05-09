package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DTO.ProductsDTO;

@Service
public interface IProductService {
	@Autowired
	public ProductsDTO GetProductByID(long id);
	public List<ProductsDTO> GetProductByIDCategory(long id);
	public List<ProductsDTO> GetDataProducts();
	public int AddProduct(ProductsDTO product);
	public int UpdateProduct(ProductsDTO product);
	public int DeleteProduct(ProductsDTO product);
}
