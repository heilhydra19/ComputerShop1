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
import ComputerShop1.Entity.Categories;
import ComputerShop1.Service.CategoryServiceImpl;
import ComputerShop1.Service.PaginateServiceImpl;

@Controller
public class AdCategoryController extends AdBaseController {
	@Autowired
	private CategoryServiceImpl _categoryService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalCategoriesPage = 30;

	@RequestMapping(value = "quan-tri/loai", method = RequestMethod.GET)
	public ModelAndView Category() {
		_mvShare.clear();
		_mvShare.setViewName("admin/category/category");
		int totalData = _categoryService.GetDataCategories().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCategoriesPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("categoriesPaginate",
				_categoryService.GetDataCategoriesPaginate(null, paginateInfo.getStart(), totalCategoriesPage));
		_mvShare.addObject("categories", _categoryService.GetDataCategories());
		_mvShare.addObject("category", new Categories());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/loai/{currentPage}", method = RequestMethod.GET)
	public ModelAndView Category(@PathVariable String currentPage) {
		_mvShare.setViewName("admin/category/category");
		int totalData = _categoryService.GetDataCategories().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCategoriesPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("categoriesPaginate",
				_categoryService.GetDataCategoriesPaginate(null, paginateInfo.getStart(), totalCategoriesPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/loai/addorupdate", method = RequestMethod.POST, params = "add")
	public String AddCategory(@ModelAttribute("category") Categories category) {
		_categoryService.AddCategory(category);
		return "redirect:/quan-tri/loai";
	}

	@RequestMapping(value = "/quan-tri/loai/addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateCategory(@ModelAttribute("category") Categories category) {
		_categoryService.UpdateCategory(category);
		return "redirect:/quan-tri/loai";
	}

	@RequestMapping(value = "/quan-tri/loai/delete/{id}", method = RequestMethod.GET)
	public String DeleteCategory(@PathVariable("id") long id) {
		_categoryService.DeleteCategory(id);
		return "redirect:/quan-tri/loai";
	}

	@RequestMapping(value = "/quan-tri/loai/search", method = RequestMethod.POST)
	public String SearchCategory(@RequestParam("keyword") String keyword) {
		_mvShare.clear();
		return "redirect:/quan-tri/loai/search/" + keyword;
	}

	@RequestMapping(value = "/quan-tri/loai/search/{keyword}", method = RequestMethod.GET)
	public ModelAndView SearchCategory1(@PathVariable("keyword") String keyword) {
		if (keyword != null) {
			_mvShare.setViewName("admin/category/category");
			int totalData = _categoryService.SearchCategory(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCategoriesPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("categoriesPaginate",
					_categoryService.GetDataCategoriesPaginate(keyword, paginateInfo.getStart(), totalCategoriesPage));
			_mvShare.addObject("categories", _categoryService.SearchCategory(keyword));
			_mvShare.addObject("category", new Categories());
			_mvShare.addObject("keyword", keyword);
		}
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/loai/search/{keyword}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView SearchCategory(@PathVariable("keyword") String keyword, @PathVariable String currentPage) {
		if (keyword != null) {
			_mvShare.setViewName("admin/category/category");
			int totalData = _categoryService.SearchCategory(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCategoriesPage,
					Integer.parseInt(currentPage));
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("categoriesPaginate",
					_categoryService.GetDataCategoriesPaginate(keyword, paginateInfo.getStart(), totalCategoriesPage));
		}
		return _mvShare;
	}
}
