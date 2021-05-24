package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.Entity.Brands;
import ComputerShop1.Service.BrandServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/hang")
public class AdBrandController extends AdBaseController{
	@Autowired
	private BrandServiceImpl _brandService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Brand() {
		_mvShare.addObject("brands", _brandService.GetDataBrands());
		_mvShare.setViewName("admin/brand/brand");
		_mvShare.addObject("brand", new Brands());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddBrand(@ModelAttribute("brand") Brands brand) {
		_brandService.AddBrand(brand);
		return "redirect:/quan-tri/hang";
	}
	
	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateBrand(@ModelAttribute("brand") Brands brand) {
		_brandService.UpdateBrand(brand);
		return "redirect:/quan-tri/hang";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String DeleteBrand(@PathVariable("id") long id) {
		_brandService.DeleteBrand(id);
		return "redirect:/quan-tri/hang";
	}
}
