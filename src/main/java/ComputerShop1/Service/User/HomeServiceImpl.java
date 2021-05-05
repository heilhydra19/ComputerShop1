package ComputerShop1.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.CategoriesDAO;
import ComputerShop1.DAO.MenuDAO;
import ComputerShop1.DAO.SlidesDAO;
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
	
	public List<Slides> GetDataSlide() {
		return slidesDAO.GetDataSlide();
	}

	public List<Categories> GetDataCategories() {
		return categoriesDAO.GetDataCategories();
	}

	public List<Menu> GetDataMenu() {
		return menuDAO.GetDataMenu();
	}

}
