package ComputerShop1.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.PaginatesDTO;
import ComputerShop1.Service.User.CategoryServiceImpl;
import ComputerShop1.Service.User.PaginateServiceImpl;

@Controller
public class CategoryController extends BaseController{
	
	@Autowired
	private CategoryServiceImpl categoryService;
    
	@Autowired
	private PaginateServiceImpl paginateService;
	
	private int totalProductsPage = 9;
	
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/product/category");
		int totalData = categoryService.GetProductByIDCategory(Long.parseLong(id)).size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Long.parseLong(id), paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {
		_mvShare.setViewName("user/product/category");
		int totalData = categoryService.GetProductByIDCategory(Integer.parseInt(id)).size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Long.parseLong(id) ,paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
}
