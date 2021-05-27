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
import ComputerShop1.DTO.PaginatesDTO;
import ComputerShop1.Service.ImportServiceImpl;
import ComputerShop1.Service.PaginateServiceImpl;
import ComputerShop1.Service.SupplierServiceImpl;

@Controller
public class AdImportsController extends AdBaseController {
	@Autowired
	private ImportServiceImpl _importService;
	@Autowired
	private SupplierServiceImpl _supplierService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalImportsPage = 30;

	@RequestMapping(value = "quan-tri/nhap-hang", method = RequestMethod.GET)
	public ModelAndView Import() {
		_mvShare.clear();
		int totalData = _importService.GetDataImports().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalImportsPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("importsPaginate",
				_importService.GetDataImportsPaginate(null, paginateInfo.getStart(), totalImportsPage));
		_mvShare.addObject("imports", _importService.GetDataImports());
		_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
		_mvShare.setViewName("admin/import/import");
		_mvShare.addObject("import", new ImportsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/nhap-hang/{currentPage}", method = RequestMethod.GET)
	public ModelAndView Import(@PathVariable String currentPage) {
		int totalData = _importService.GetDataImports().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalImportsPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("importsPaginate",
				_importService.GetDataImportsPaginate(null, paginateInfo.getStart(), totalImportsPage));
		_mvShare.addObject("imports", _importService.GetDataImports());
		_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
		_mvShare.setViewName("admin/import/import");
		_mvShare.addObject("import", new ImportsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/nhap-hang/addorupdate", method = RequestMethod.POST, params = "add")
	public String AddBill(@ModelAttribute("import") ImportsDTO imports) {
		_importService.AddImport(imports);
		return "redirect:/quan-tri/nhap-hang";
	}

	@RequestMapping(value = "/quan-tri/nhap-hang/addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateBill(@ModelAttribute("import") ImportsDTO imports) {
		_importService.UpdateImport(imports);
		return "redirect:/quan-tri/nhap-hang";
	}

	@RequestMapping(value = "/quan-tri/nhap-hang/delete/{id}", method = RequestMethod.GET)
	public String DeleteBill(@PathVariable("id") long id) {
		_importService.DeleteImport(id);
		return "redirect:/quan-tri/nhap-hang";
	}

	@RequestMapping(value = "/quan-tri/nhap-hang/search", method = RequestMethod.POST)
	public String SearchImport(@RequestParam("keyword") String keyword) {
		_mvShare.clear();
		return "redirect:/quan-tri/nhap-hang/search/" + keyword;
	}

	@RequestMapping(value = "/quan-tri/nhap-hang/search/{keyword}", method = RequestMethod.GET)
	public ModelAndView SearchImport1(@PathVariable("keyword") String keyword) {
		if (keyword != null) {
			int totalData = _importService.SearchImport(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalImportsPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("importsPaginate",
					_importService.GetDataImportsPaginate(keyword, paginateInfo.getStart(), totalImportsPage));
			_mvShare.addObject("imports", _importService.SearchImport(keyword));
			_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
			_mvShare.setViewName("admin/import/import");
			_mvShare.addObject("import", new ImportsDTO());
			_mvShare.addObject("keyword",keyword);
		}
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/nhap-hang/search/{keyword}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView SearchImport(@PathVariable("keyword") String keyword, @PathVariable String currentPage) {
		if (keyword != null) {
			int totalData = _importService.SearchImport(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalImportsPage,
					Integer.parseInt(currentPage));
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("importsPaginate",
					_importService.GetDataImportsPaginate(keyword, paginateInfo.getStart(), totalImportsPage));
			_mvShare.setViewName("admin/import/import");
		}
		return _mvShare;
	}
}
