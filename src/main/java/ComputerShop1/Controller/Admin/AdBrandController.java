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
import ComputerShop1.Entity.Brands;
import ComputerShop1.Service.BrandServiceImpl;
import ComputerShop1.Service.PaginateServiceImpl;

@Controller
public class AdBrandController extends AdBaseController {
	@Autowired
	private BrandServiceImpl _brandService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalBrandsPage = 30;

	@RequestMapping(value = "quan-tri/hang", method = RequestMethod.GET)
	public ModelAndView Brand() {
		_mvShare.clear();
		_mvShare.setViewName("admin/brand/brand");
		int totalData = _brandService.GetDataBrands().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalBrandsPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("brandsPaginate",
				_brandService.GetDataBrandsPaginate(null, paginateInfo.getStart(), totalBrandsPage));
		_mvShare.addObject("brands", _brandService.GetDataBrands());
		_mvShare.addObject("brand", new Brands());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/hang/{currentPage}", method = RequestMethod.GET)
	public ModelAndView Brand(@PathVariable String currentPage) {
		_mvShare.setViewName("admin/brand/brand");
		int totalData = _brandService.GetDataBrands().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalBrandsPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("brandsPaginate",
				_brandService.GetDataBrandsPaginate(null, paginateInfo.getStart(), totalBrandsPage));
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/hang/addorupdate", method = RequestMethod.POST, params = "add")
	public String AddBrand(@ModelAttribute("brand") Brands brand) {
		_brandService.AddBrand(brand);
		return "redirect:/quan-tri/hang";
	}

	@RequestMapping(value = "/quan-tri/hang/addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateBrand(@ModelAttribute("brand") Brands brand) {
		_brandService.UpdateBrand(brand);
		return "redirect:/quan-tri/hang";
	}

	@RequestMapping(value = "/quan-tri/hang/delete/{id}", method = RequestMethod.GET)
	public String DeleteBrand(@PathVariable("id") long id) {
		_brandService.DeleteBrand(id);
		return "redirect:/quan-tri/hang";
	}
	

	@RequestMapping(value = "/quan-tri/hang/search", method = RequestMethod.POST)
	public String SearchBrand(@RequestParam("keyword") String keyword) {
		_mvShare.clear();
		return "redirect:/quan-tri/hang/search/"+keyword;
	}

	@RequestMapping(value = "/quan-tri/hang/search/{keyword}", method = RequestMethod.GET)
	public ModelAndView SearchBrand1(@PathVariable("keyword") String keyword) {
		_mvShare.setViewName("admin/brand/brand");
		if (keyword != null) {
			int totalData = _brandService.SearchBrand(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalBrandsPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("brandsPaginate",
					_brandService.GetDataBrandsPaginate(keyword, paginateInfo.getStart(), totalBrandsPage));
			_mvShare.addObject("brands", _brandService.SearchBrand(keyword));
			_mvShare.addObject("brand", new Brands());
			_mvShare.addObject("keyword",keyword);
		}
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/hang/search/{keyword}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView SearchBrand(@PathVariable("keyword") String keyword, @PathVariable String currentPage) {
		_mvShare.setViewName("admin/brand/brand");
		if (keyword != null) {
			int totalData = _brandService.SearchBrand(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalBrandsPage,
					Integer.parseInt(currentPage));
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("brandsPaginate",
					_brandService.GetDataBrandsPaginate(keyword, paginateInfo.getStart(), totalBrandsPage));
		}
		return _mvShare;
	}
}
