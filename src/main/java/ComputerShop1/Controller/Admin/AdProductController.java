package ComputerShop1.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.ProductsDTO;

@Controller
public class AdProductController extends AdBaseController{
	@RequestMapping(value = "/quan-tri/")
	public ModelAndView Index() {
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.setViewName("admin/index");
		return _mvShare;
	}
	@RequestMapping(value = "/AddSave", method = RequestMethod.GET)
	public ModelAndView AddProduct() {
		_mvShare.setViewName("admin/index");
		_mvShare.addObject("product", new ProductsDTO());
		return _mvShare;
	}
	@RequestMapping(value = "/AddSave", method = RequestMethod.POST)
	public ModelAndView AddProductSave(@ModelAttribute("product") ProductsDTO product) {
	 	int count = _productService.AddProduct(product);
	 	if(count > 0) {
	 		_mvShare.addObject("status", "Đăng ký tài khoản thành công");
	 	}
	 	else {
	 		_mvShare.addObject("status", "Đăng ký tài khoản thất bại");
	 	}
	 	_mvShare.setViewName("admin/index");
		return _mvShare;
	}
}
