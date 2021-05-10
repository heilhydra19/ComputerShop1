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
import ComputerShop1.Service.ProductServiceImpl;

@Controller
public class AdProductController extends AdBaseController {
	@Autowired
	private ProductServiceImpl _productService;
	@Autowired
	private CategoryServiceImpl _categoryService;
	@Autowired
	private BrandServiceImpl _brandService;
	
	private ModelAndView View() {
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.addObject("categories", _categoryService.GetDataCategories());
		_mvShare.addObject("brands", _brandService.GetDataBrands());
		_mvShare.setViewName("admin/product/product");
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/san-pham", method = RequestMethod.GET)
	public ModelAndView Product() {
		View();
		_mvShare.addObject("product", new ProductsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/san-pham", method = RequestMethod.POST, params = "add")
	public ModelAndView AddProduct(@ModelAttribute("product") ProductsDTO product) {
		_productService.AddProduct(product);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/san-pham", method = RequestMethod.POST, params = "update")
	public ModelAndView UpdateProduct(@ModelAttribute("product") ProductsDTO product) {
		_productService.UpdateProduct(product);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/san-pham", method = RequestMethod.POST, params = "delete")
	public ModelAndView DeleteProduct(@ModelAttribute("product") ProductsDTO product) {
		_productService.DeleteProduct(product);
		View();
		return _mvShare;
	}
}
