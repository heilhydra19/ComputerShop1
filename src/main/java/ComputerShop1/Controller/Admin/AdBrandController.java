package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.Entity.Brands;
import ComputerShop1.Service.BrandServiceImpl;

@Controller
public class AdBrandController extends AdBaseController{
	@Autowired
	private BrandServiceImpl _brandService;
	
	private ModelAndView View() {
		_mvShare.addObject("brands", _brandService.GetDataBrands());
		_mvShare.setViewName("admin/brand/brand");
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/hang", method = RequestMethod.GET)
	public ModelAndView Product() {
		View();
		_mvShare.addObject("brand", new Brands());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/hang", method = RequestMethod.POST, params = "add")
	public ModelAndView AddBrand(@ModelAttribute("brand") Brands brand) {
		_brandService.AddBrand(brand);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/hang", method = RequestMethod.POST, params = "update")
	public ModelAndView UpdateBrand(@ModelAttribute("brand") Brands brand) {
		_brandService.UpdateBrand(brand);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/hang", method = RequestMethod.POST, params = "delete")
	public ModelAndView DeleteBrand(@ModelAttribute("brand") Brands brand) {
		_brandService.DeleteBrand(brand);
		View();
		return _mvShare;
	}
}
