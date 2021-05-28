package ComputerShop1.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.PaginatesDTO;
import ComputerShop1.DTO.ProductsDTO;
import ComputerShop1.Service.PaginateServiceImpl;
import ComputerShop1.Service.ProductServiceImpl;

@Controller
public class ProductController extends BaseController{
	@Autowired
	private ProductServiceImpl _productService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalProductsPage = 9;
	
	@RequestMapping(value = "/san-pham", method = RequestMethod.GET)
	public ModelAndView Product() {
		_mvShare.clear();
		int totalData = _productService.GetDataProducts().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate",
				_productService.GetDataProductsPaginate(null, paginateInfo.getStart(), totalProductsPage));
		_mvShare.setViewName("user/product/products");
		_mvShare.addObject("product", new ProductsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "/san-pham/{currentPage}", method = RequestMethod.GET)
	public ModelAndView Product(@PathVariable String currentPage) {
		int totalData = _productService.GetDataProducts().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate",
				_productService.GetDataProductsPaginate(null, paginateInfo.getStart(), totalProductsPage));
		_mvShare.setViewName("user/product/products");
		return _mvShare;
	}
	
	@RequestMapping(value = {"/chi-tiet-san-pham/{id}"})
	public ModelAndView ProductByTD(@PathVariable long id) {
		_mvShare.setViewName("user/product/product");
		_mvShare.addObject("product", _productService.GetProductByID(id));
		_mvShare.addObject("productByIdCategory", _productService.GetProductByIDCategory(id));
		return _mvShare;
	}
}
