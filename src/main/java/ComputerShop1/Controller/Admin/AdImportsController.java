package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.ImportsDTO;
import ComputerShop1.Service.ImportServiceImpl;
import ComputerShop1.Service.SupplierServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/nhap-hang")
public class AdImportsController extends AdBaseController {
	@Autowired
	private ImportServiceImpl _importService;

	@Autowired
	private SupplierServiceImpl _supplierService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Import() {
		_mvShare.addObject("imports", _importService.GetDataImports());
		_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
		_mvShare.setViewName("admin/import/import");
		_mvShare.addObject("import", new ImportsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddBill(@ModelAttribute("import") ImportsDTO imports) {
		_importService.AddImport(imports);
		return "redirect:/quan-tri/nhap-hang";
	}
	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateBill(@ModelAttribute("import") ImportsDTO imports) {
		_importService.UpdateImport(imports);
		return "redirect:/quan-tri/nhap-hang";
	}
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String DeleteBill(@PathVariable("id") long id) {
		_importService.DeleteImport(id);
		return "redirect:/quan-tri/nhap-hang";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView SearchImport(@RequestParam("keyword") String keyword) {
		if(keyword != null) {
			_mvShare.addObject("imports", _importService.SearchImport(keyword));
		}
		else {
			_mvShare.addObject("imports", _importService.GetDataImports());
		}
		_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
		_mvShare.setViewName("admin/import/import");
		return _mvShare;
	}
}
