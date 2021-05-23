package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.BillDetailsDTO;
import ComputerShop1.Service.BillServiceImpl;
import ComputerShop1.Service.ProductServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/hoa-don/{id}")
public class AdBillDetailsController extends AdBaseController{
	@Autowired
	private BillServiceImpl _billService;
	
	@Autowired
	private ProductServiceImpl _productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView BillDetail(@PathVariable long id) {
		_mvShare.addObject("billDetails", _billService.GetDataBillDetailById(id));
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.addObject("totalPrice", _billService.GetTotalPrice(id));
		_mvShare.setViewName("admin/bill/billdetail");
		_mvShare.addObject("id", id);
		_mvShare.addObject("billDetail", new BillDetailsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddBillDetail(@ModelAttribute("billDetail") BillDetailsDTO billDetail) {
		_billService.AddBillDetail(billDetail);
		return "redirect:/quan-tri/hoa-don/{id}";
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateBillDetail(@ModelAttribute("billDetail") BillDetailsDTO billDetail) {
		_billService.UpdateBillDetail(billDetail);
		return "redirect:/quan-tri/hoa-don/{id}";
	}
	@RequestMapping(value = "delete/{idDetail}", method = RequestMethod.GET)
	public String DeleteBillDetail(@PathVariable("id") long id, @PathVariable("idDetail") long idDetail) {
		_billService.DeleteBillDetail(id,idDetail);
		return "redirect:/quan-tri/hoa-don/{id}";
	}
}
