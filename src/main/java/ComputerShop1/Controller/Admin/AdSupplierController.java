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
import ComputerShop1.Entity.Suppliers;
import ComputerShop1.Service.PaginateServiceImpl;
import ComputerShop1.Service.SupplierServiceImpl;

@Controller
public class AdSupplierController extends AdBaseController {
	@Autowired
	private SupplierServiceImpl _supplierService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalSuppliersPage = 30;

	@RequestMapping(value = "quan-tri/nha-cung-cap", method = RequestMethod.GET)
	public ModelAndView Supplier() {
		_mvShare.clear();
		_mvShare.setViewName("admin/supplier/supplier");
		int totalData = _supplierService.GetDataSuppliers().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalSuppliersPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("suppliersPaginate",
				_supplierService.GetDataSuppliersPaginate(null, paginateInfo.getStart(), totalSuppliersPage));
		_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
		_mvShare.addObject("supplier", new Suppliers());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/nha-cung-cap/{currentPage}", method = RequestMethod.GET)
	public ModelAndView Supplier(@PathVariable String currentPage) {
		_mvShare.setViewName("admin/supplier/supplier");
		int totalData = _supplierService.GetDataSuppliers().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalSuppliersPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("suppliersPaginate",
				_supplierService.GetDataSuppliersPaginate(null, paginateInfo.getStart(), totalSuppliersPage));
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/nha-cung-cap/addorupdate", method = RequestMethod.POST, params = "add")
	public String AddSupplier(@ModelAttribute("supplier") Suppliers supplier) {
		_supplierService.AddSupplier(supplier);
		return "redirect:/quan-tri/nha-cung-cap";
	}

	@RequestMapping(value = "/quan-tri/nha-cung-cap/addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateSupplier(@ModelAttribute("supplier") Suppliers supplier) {
		_supplierService.UpdateSupplier(supplier);
		return "redirect:/quan-tri/nha-cung-cap";
	}

	@RequestMapping(value = "/quan-tri/nha-cung-cap/delete/{id}", method = RequestMethod.GET)
	public String DeleteSupplier(@PathVariable("id") long id) {
		_supplierService.DeleteSupplier(id);
		return "redirect:/quan-tri/nha-cung-cap";
	}

	@RequestMapping(value = "/quan-tri/nha-cung-cap/search", method = RequestMethod.POST)
	public String SearchSupplier(@RequestParam("keyword") String keyword) {
		_mvShare.clear();
		return "redirect:/quan-tri/nha-cung-cap/search/" + keyword;
	}
	
	@RequestMapping(value = "/quan-tri/nha-cung-cap/search/{keyword}", method = RequestMethod.GET)
	public ModelAndView SearchSupplier1(@PathVariable("keyword") String keyword) {
		_mvShare.setViewName("admin/supplier/supplier");
		if (keyword != null) {
			int totalData = _supplierService.SearchSupplier(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalSuppliersPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("suppliersPaginate",
					_supplierService.GetDataSuppliersPaginate(keyword, paginateInfo.getStart(), totalSuppliersPage));
			_mvShare.addObject("suppliers", _supplierService.SearchSupplier(keyword));
			_mvShare.addObject("supplier", new Suppliers());
			_mvShare.addObject("keyword",keyword);
		}
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/nha-cung-cap/search/{keyword}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView SearchSupplier(@PathVariable("keyword") String keyword, @PathVariable String currentPage) {
		_mvShare.setViewName("admin/supplier/supplier");
		if (keyword != null) {
			int totalData = _supplierService.SearchSupplier(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalSuppliersPage,
					Integer.parseInt(currentPage));
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("suppliersPaginate",
					_supplierService.GetDataSuppliersPaginate(keyword, paginateInfo.getStart(), totalSuppliersPage));
		}
		return _mvShare;
	}
}
