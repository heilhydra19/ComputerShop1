package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.ImportDetailsDTO;
import ComputerShop1.DTO.PaginatesDTO;
import ComputerShop1.Service.ImportServiceImpl;
import ComputerShop1.Service.PaginateServiceImpl;
import ComputerShop1.Service.ProductServiceImpl;

@Controller
public class AdImportDetailsController extends AdBaseController{
	@Autowired
	private ImportServiceImpl _importService;
	
	@Autowired
	private ProductServiceImpl _productService;

	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalImportDetailsPage = 30;
	
	@RequestMapping(value = "quan-tri/nhap-hang/import{id}", method = RequestMethod.GET)
	public ModelAndView ImportDetail(@PathVariable long id) {
		_mvShare.addObject("importDetails", _importService.GetDataImportDetailById(id));
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.addObject("totalPrice", _importService.GetTotalPrice(id));
		_mvShare.setViewName("admin/import/importdetail");
		_mvShare.addObject("id", id);
		_mvShare.addObject("importDetail", new ImportDetailsDTO());
		int totalData = _importService.GetDataImportDetailById(id).size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalImportDetailsPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("importDetailsPaginate",
				_importService.GetDataImportDetailsPaginate(id, paginateInfo.getStart(), totalImportDetailsPage));
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/nhap-hang/import{id}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView BillDetail(@PathVariable long id, @PathVariable String currentPage) {
		_mvShare.addObject("importDetails", _importService.GetDataImportDetailById(id));
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.addObject("totalPrice", _importService.GetTotalPrice(id));
		_mvShare.setViewName("admin/import/importdetail");
		_mvShare.addObject("id", id);
		_mvShare.addObject("importDetail", new ImportDetailsDTO());
		int totalData = _importService.GetDataImportDetailById(id).size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalImportDetailsPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("importDetailsPaginate",
				_importService.GetDataImportDetailsPaginate(id, paginateInfo.getStart(), totalImportDetailsPage));
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/nhap-hang/import{id}/addorupdate", method = RequestMethod.POST, params = "add")
	public String AddImportDetail(@ModelAttribute("importDetail") ImportDetailsDTO importDetail) {
		_importService.AddImportDetail(importDetail);
		return "redirect:/quan-tri/nhap-hang/import{id}";
	}

	@RequestMapping(value = "/quan-tri/nhap-hang/import{id}/addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateImportDetail(@ModelAttribute("importDetail") ImportDetailsDTO importDetail) {
		_importService.UpdateImportDetail(importDetail);
		return "redirect:/quan-tri/nhap-hang/import{id}";
	}
	@RequestMapping(value = "/quan-tri/nhap-hang/import{id}/delete/{idDetail}", method = RequestMethod.GET)
	public String DeleteImportDetail(@PathVariable("id") long id, @PathVariable("idDetail") long idDetail) {
		_importService.DeleteImportDetail(id,idDetail);
		return "redirect:/quan-tri/nhap-hang/import{id}";
	}
}
