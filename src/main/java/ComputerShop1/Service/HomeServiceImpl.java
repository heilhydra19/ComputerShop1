package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.CategoriesDAO;
import ComputerShop1.DAO.MenuDAO;
import ComputerShop1.DAO.ProductsDAO;
import ComputerShop1.DAO.SlidesDAO;
import ComputerShop1.DTO.ProductsDTO;
import ComputerShop1.Entity.Categories;
import ComputerShop1.Entity.Menu;
import ComputerShop1.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SlidesDAO slidesDAO;
	@Autowired
	private CategoriesDAO categoriesDAO;
	@Autowired
	private MenuDAO menuDAO;
	@Autowired
	ProductsDAO productDAO = new ProductsDAO();
	
	public List<Slides> GetDataSlide() {
		return slidesDAO.GetDataSlide();
	}

	public List<Categories> GetDataCategories() {
		return categoriesDAO.GetDataCategories();
	}

	public List<Menu> GetDataMenu() {
		return menuDAO.GetDataMenu();
	}
	
	public List<ProductsDTO> GetDataHomeProducts(){
		return productDAO.GetDataHomeProducts();
	}

	public List<ProductsDTO> GetDataNewProducts() {
		return productDAO.GetDataNewProducts();
	}

	public List<ProductsDTO> GetDataProducts() {
		List<ProductsDTO> listProducts = productDAO.GetDataProducts();
		listProducts.get(0).getImg();
		return listProducts;
	}
}
