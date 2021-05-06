package ComputerShop1.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController{
	@Autowired
	private ProductServiceImpl _productServiceImpl;
	
	@RequestMapping(value = {"chi-tiet-san-pham/{id}"})
	public ModelAndView Index(@PathVariable long id) {
		_mvShare.setViewName("user/product/product");
		_mvShare.addObject("product", _productServiceImpl.GetProductByID(id));
		return _mvShare;
	}
}
