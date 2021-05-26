package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.PaginatesDTO;
import ComputerShop1.DTO.ProductsDTO;
import ComputerShop1.Service.BrandServiceImpl;
import ComputerShop1.Service.CategoryServiceImpl;
import ComputerShop1.Service.PaginateServiceImpl;
import ComputerShop1.Service.ProductServiceImpl;

@Controller

public class AdProductController extends AdBaseController {
	@Autowired
	private ProductServiceImpl _productService;
	@Autowired
	private CategoryServiceImpl _categoryService;
	@Autowired
	private BrandServiceImpl _brandService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalProductsPage = 30;

	@RequestMapping(value = "quan-tri/san-pham", method = RequestMethod.GET)
	public ModelAndView Product() {
		int totalData = _productService.GetDataProducts().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate",
				_productService.GetDataProductsPaginate(null, paginateInfo.getStart(), totalProductsPage));
		_mvShare.addObject("categories", _categoryService.GetDataCategories());
		_mvShare.addObject("brands", _brandService.GetDataBrands());
		_mvShare.setViewName("admin/product/product");
		_mvShare.addObject("product", new ProductsDTO());
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/san-pham/{currentPage}", method = RequestMethod.GET)
	public ModelAndView Product(@PathVariable String currentPage) {
		int totalData = _productService.GetDataProducts().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate",
				_productService.GetDataProductsPaginate(null, paginateInfo.getStart(), totalProductsPage));
		_mvShare.addObject("categories", _categoryService.GetDataCategories());
		_mvShare.addObject("brands", _brandService.GetDataBrands());
		_mvShare.setViewName("admin/product/product");
		_mvShare.addObject("product", new ProductsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/san-pham/addorupdate", method = RequestMethod.POST, params = "add")
	public String AddProduct(@ModelAttribute("product") ProductsDTO product) {
		_productService.AddProduct(product);
		return "redirect:/quan-tri/san-pham";
	}

	@RequestMapping(value = "/quan-tri/san-pham/addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateProduct(@ModelAttribute("product") ProductsDTO product) {
		_productService.UpdateProduct(product);
		return "redirect:/quan-tri/san-pham";
	}

	@RequestMapping(value = "/quan-tri/san-pham/delete/{id}", method = RequestMethod.GET)
	public String DeleteProduct(@PathVariable("id") long id) {
		_productService.DeleteProduct(id);
		return "redirect:/quan-tri/san-pham";
	}

	@RequestMapping(value = "/quan-tri/san-pham/search", method = RequestMethod.POST)
	public ModelAndView SearchProduct(@RequestParam("keyword") String keyword) {
		if (keyword != null) {
			int totalData = _productService.GetDataProducts().size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("productsPaginate",
					_productService.GetDataProductsPaginate(keyword, paginateInfo.getStart(), totalProductsPage));
			_mvShare.addObject("categories", _categoryService.GetDataCategories());
			_mvShare.addObject("brands", _brandService.GetDataBrands());
			_mvShare.setViewName("admin/product/product");
			_mvShare.addObject("product", new ProductsDTO());
		}
		return _mvShare;
	}
	
	@RequestMapping(value = "/quan-tri/san-pham/search/{currentPage}", method = RequestMethod.POST)
	public ModelAndView SearchProduct(@RequestParam("keyword")String keyword, @PathVariable String currentPage) {
		if (keyword != null) {
			int totalData = _productService.GetDataProducts().size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("productsPaginate",
					_productService.GetDataProductsPaginate(keyword, paginateInfo.getStart(), totalProductsPage));
			_mvShare.addObject("categories", _categoryService.GetDataCategories());
			_mvShare.addObject("brands", _brandService.GetDataBrands());
			_mvShare.setViewName("admin/product/product");
			_mvShare.addObject("product", new ProductsDTO());
		}
		return _mvShare;
	}
}
