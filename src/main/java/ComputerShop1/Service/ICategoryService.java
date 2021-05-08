package ComputerShop1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ComputerShop1.DTO.ProductsDTO;

@Service
public interface ICategoryService {
	public List<ProductsDTO> GetProductByIDCategory(long id);
}
