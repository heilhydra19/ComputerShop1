package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.ProductsDTO;
import ComputerShop1.Service.BrandServiceImpl;
import ComputerShop1.Service.CategoryServiceImpl;

@Controller
public class AdProductController extends AdBaseController {
	@Autowired
	private CategoryServiceImpl _categoryService;
	@Autowired
	private BrandServiceImpl _brandService;
	
	@RequestMapping(value = "quan-tri/quan-ly", method = RequestMethod.GET)
	public ModelAndView AddProduct() {
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.addObject("categories", _categoryService.GetDataCategories());
		_mvShare.addObject("brands", _brandService.GetDataBrands());
		_mvShare.setViewName("admin/product/product");
		_mvShare.addObject("product", new ProductsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/quan-ly", method = RequestMethod.POST)
	public ModelAndView AddProductSave(@ModelAttribute("product") ProductsDTO product) {
		int count = _productService.AddProduct(product);
		if (count > 0) {
			_mvShare.addObject("status", "Đăng ký tài khoản thành công");
		} else {
			_mvShare.addObject("status", "Đăng ký tài khoản thất bại");
		}
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.addObject("categories", _categoryService.GetDataCategories());
		_mvShare.addObject("brands", _brandService.GetDataBrands());
		_mvShare.setViewName("admin/product/product");
		return _mvShare;
	}
}
