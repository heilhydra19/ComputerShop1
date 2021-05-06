package ComputerShop1.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DTO.ProductsDTO;
import ComputerShop1.Entity.Categories;
import ComputerShop1.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	public List<Categories> GetDataCategories();
	public List<ProductsDTO> GetDataNewProducts();
	public List<ProductsDTO> GetDataHomeProducts();
}
