package ComputerShop1.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("categories", _homeService.GetDataCategories());
		_mvShare.addObject("newproducts", _homeService.GetDataNewProducts());
		_mvShare.addObject("products", _homeService.GetDataHomeProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
}
