package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.Entity.Categories;
import ComputerShop1.Service.CategoryServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/loai")
public class AdCategoryController extends AdBaseController{
	@Autowired
	private CategoryServiceImpl _categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Product() {
		_mvShare.addObject("categories", _categoryService.GetDataCategories());
		_mvShare.setViewName("admin/category/category");
		_mvShare.addObject("category", new Categories());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddCategory(@ModelAttribute("category") Categories category) {
		_categoryService.AddCategory(category);
		return "redirect:/quan-tri/loai";
	}
	
	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateCategory(@ModelAttribute("category") Categories category) {
		_categoryService.UpdateCategory(category);
		return "redirect:/quan-tri/loai";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String DeleteCategory(@PathVariable("id") long id) {
		_categoryService.DeleteCategory(id);
		return "redirect:/quan-tri/loai";
	}
}
