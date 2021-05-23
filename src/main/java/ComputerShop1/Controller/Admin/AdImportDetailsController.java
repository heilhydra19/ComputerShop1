package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.ImportDetailsDTO;
import ComputerShop1.Service.ImportServiceImpl;
import ComputerShop1.Service.ProductServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/nhap-hang/{id}")
public class AdImportDetailsController extends AdBaseController{
	@Autowired
	private ImportServiceImpl _importService;
	
	@Autowired
	private ProductServiceImpl _productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView ImportDetail(@PathVariable long id) {
		_mvShare.addObject("importDetails", _importService.GetDataImportDetailById(id));
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.addObject("totalPrice", _importService.GetTotalPrice(id));
		_mvShare.setViewName("admin/import/importdetail");
		_mvShare.addObject("id", id);
		_mvShare.addObject("importDetail", new ImportDetailsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddImportDetail(@ModelAttribute("importDetail") ImportDetailsDTO importDetail) {
		_importService.AddImportDetail(importDetail);
		return "redirect:/quan-tri/nhap-hang/{id}";
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateImportDetail(@ModelAttribute("importDetail") ImportDetailsDTO importDetail) {
		_importService.UpdateImportDetail(importDetail);
		return "redirect:/quan-tri/nhap-hang/{id}";
	}
	@RequestMapping(value = "delete/{idDetail}", method = RequestMethod.GET)
	public String DeleteImportDetail(@PathVariable("id") long id, @PathVariable("idDetail") long idDetail) {
		_importService.DeleteImportDetail(id,idDetail);
		return "redirect:/quan-tri/nhap-hang/{id}";
	}
}
