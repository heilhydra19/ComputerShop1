package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.Service.ProductServiceImpl;

@Controller
public class AdBaseController {
	@Autowired
	ProductServiceImpl _productService;
	public ModelAndView _mvShare = new ModelAndView();
}
