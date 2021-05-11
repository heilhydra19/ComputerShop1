package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.Entity.Suppliers;
import ComputerShop1.Service.SupplierServiceImpl;

@Controller
public class AdSupplierController extends AdBaseController{
	@Autowired
	private SupplierServiceImpl _supplierService;
	
	private ModelAndView View() {
		_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
		_mvShare.setViewName("admin/supplier/supplier");
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/nha-cung-cap", method = RequestMethod.GET)
	public ModelAndView Supplier() {
		View();
		_mvShare.addObject("supplier", new Suppliers());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/nha-cung-cap", method = RequestMethod.POST, params = "add")
	public ModelAndView AddSupplier(@ModelAttribute("supplier") Suppliers supplier) {
		_supplierService.AddSupplier(supplier);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/nha-cung-cap", method = RequestMethod.POST, params = "update")
	public ModelAndView UpdateSupplier(@ModelAttribute("supplier") Suppliers supplier) {
		_supplierService.UpdateSupplier(supplier);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/nha-cung-cap", method = RequestMethod.POST, params = "delete")
	public ModelAndView DeleteSupplier(@ModelAttribute("supplier") Suppliers supplier) {
		_supplierService.DeleteSupplier(supplier);
		View();
		return _mvShare;
	}
}
