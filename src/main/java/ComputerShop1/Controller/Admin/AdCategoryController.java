package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.Entity.Categories;
import ComputerShop1.Service.CategoryServiceImpl;

@Controller
public class AdCategoryController extends AdBaseController{
	@Autowired
	private CategoryServiceImpl _categoryService;
	
	private ModelAndView View() {
		_mvShare.addObject("categories", _categoryService.GetDataCategories());
		_mvShare.setViewName("admin/category/category");
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/loai", method = RequestMethod.GET)
	public ModelAndView Product() {
		View();
		_mvShare.addObject("category", new Categories());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/loai", method = RequestMethod.POST, params = "add")
	public ModelAndView AddCategory(@ModelAttribute("category") Categories category) {
		_categoryService.AddCategory(category);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/loai", method = RequestMethod.POST, params = "update")
	public ModelAndView UpdateCategory(@ModelAttribute("category") Categories category) {
		_categoryService.UpdateCategory(category);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/loai", method = RequestMethod.POST, params = "delete")
	public ModelAndView DeleteCategory(@ModelAttribute("category") Categories category) {
		_categoryService.DeleteCategory(category);
		View();
		return _mvShare;
	}
}
