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

	private int totalCategoriesPage = 30;

	@RequestMapping(value = "quan-tri/nhap-hang", method = RequestMethod.GET)
	public ModelAndView Import() {
		int totalData = _importService.GetDataImports().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCategoriesPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("importsPaginate",
				_importService.GetDataImportsPaginate(null, paginateInfo.getStart(), totalCategoriesPage));
		_mvShare.addObject("imports", _importService.GetDataImports());
		_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
		_mvShare.setViewName("admin/import/import");
		_mvShare.addObject("import", new ImportsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/nhap-hang/{currentPage}", method = RequestMethod.GET)
	public ModelAndView Import(@PathVariable String currentPage) {
		int totalData = _importService.GetDataImports().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCategoriesPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("importsPaginate",
				_importService.GetDataImportsPaginate(null, paginateInfo.getStart(), totalCategoriesPage));
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
	public ModelAndView SearchCategory(@RequestParam("keyword") String keyword) {
		if (keyword != null) {
			int totalData = _importService.GetDataImports().size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCategoriesPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("importsPaginate",
					_importService.GetDataImportsPaginate(keyword, paginateInfo.getStart(), totalCategoriesPage));
			_mvShare.addObject("imports", _importService.GetDataImports());
			_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
			_mvShare.setViewName("admin/import/import");
			_mvShare.addObject("import", new ImportsDTO());
		}
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/nhap-hang/search/{currentPage}", method = RequestMethod.POST)
	public ModelAndView SearchCategory(@RequestParam("keyword") String keyword, @PathVariable String currentPage) {
		_mvShare.setViewName("admin/category/category");
		if (keyword != null) {
			int totalData = _importService.GetDataImports().size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCategoriesPage,
					Integer.parseInt(currentPage));
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("importsPaginate",
					_importService.GetDataImportsPaginate(keyword, paginateInfo.getStart(), totalCategoriesPage));
			_mvShare.addObject("imports", _importService.GetDataImports());
			_mvShare.addObject("suppliers", _supplierService.GetDataSuppliers());
			_mvShare.setViewName("admin/import/import");
			_mvShare.addObject("import", new ImportsDTO());
		}
		return _mvShare;
	}
}
