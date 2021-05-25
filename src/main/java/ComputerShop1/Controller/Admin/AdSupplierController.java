package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.Entity.Suppliers;
import ComputerShop1.Service.SupplierServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/nha-cung-cap")
public class AdSupplierController extends AdBaseController{
	@Autowired
	private SupplierServiceImpl _supplierService;
	
	@RequestMapping( method = RequestMethod.GET)
	public ModelAndView Supplier() {
		_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
		_mvShare.setViewName("admin/supplier/supplier");
		_mvShare.addObject("supplier", new Suppliers());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddSupplier(@ModelAttribute("supplier") Suppliers supplier) {
		_supplierService.AddSupplier(supplier);
		return "redirect:/quan-tri/nha-cung-cap";
	}
	
	@RequestMapping(value = "quan-tri/nha-cung-cap", method = RequestMethod.POST, params = "update")
	public String UpdateSupplier(@ModelAttribute("supplier") Suppliers supplier) {
		_supplierService.UpdateSupplier(supplier);
		return "redirect:/quan-tri/nha-cung-cap";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String DeleteSupplier(@PathVariable("id") long id) {
		_supplierService.DeleteSupplier(id);
		return "redirect:/quan-tri/nha-cung-cap";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView SearchSupplier(@RequestParam("keyword") String keyword) {
		if(keyword != null) {
			_mvShare.addObject("suppliers", _supplierService.SearchSupplier(keyword));
		}
		else {
			_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
		}
		_mvShare.setViewName("admin/supplier/supplier");
		return _mvShare;
	}
}
