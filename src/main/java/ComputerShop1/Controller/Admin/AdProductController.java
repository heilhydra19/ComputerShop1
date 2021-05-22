package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.ProductsDTO;
import ComputerShop1.Service.BrandServiceImpl;
import ComputerShop1.Service.CategoryServiceImpl;
import ComputerShop1.Service.ProductServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/san-pham")
public class AdProductController extends AdBaseController {
	@Autowired
	private ProductServiceImpl _productService;
	@Autowired
	private CategoryServiceImpl _categoryService;
	@Autowired
	private BrandServiceImpl _brandService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Product() {
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.addObject("categories", _categoryService.GetDataCategories());
		_mvShare.addObject("brands", _brandService.GetDataBrands());
		_mvShare.setViewName("admin/product/product");
		_mvShare.addObject("product", new ProductsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddProduct(@ModelAttribute("product") ProductsDTO product) {
		_productService.AddProduct(product);
		return "redirect:/quan-tri/san-pham";
	}
	
	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateProduct(@ModelAttribute("product") ProductsDTO product) {
		_productService.UpdateProduct(product);
		return "redirect:/quan-tri/san-pham";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String DeleteProduct(@PathVariable("id") long id) {
		_productService.DeleteProduct(id);
		return "redirect:/quan-tri/san-pham";
	}
}
