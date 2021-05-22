package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.BillDetailsDTO;
import ComputerShop1.DTO.BillsDTO;
import ComputerShop1.Service.BillServiceImpl;
import ComputerShop1.Service.ProductServiceImpl;
import ComputerShop1.Service.UserServiceImpl;

@Controller
public class AdBillsController extends AdBaseController {
	@Autowired
	private BillServiceImpl _billService;
	
	@Autowired
	private ProductServiceImpl _productService;

	@Autowired
	private UserServiceImpl _userService;

	//Bill
	@RequestMapping(value = "quan-tri/hoa-don")
	public ModelAndView Bill() {
		_mvShare.addObject("bills", _billService.GetDataBills());
		_mvShare.addObject("users", _userService.GetDataUsers());
		_mvShare.setViewName("admin/bill/bill");
		_mvShare.addObject("bill", new BillsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/hoa-don", method = RequestMethod.POST, params = "add")
	public ModelAndView AddBill(@ModelAttribute("bill") BillsDTO bill) {
		_billService.AddBill(bill);
		Bill();
		return _mvShare;
	}
	@RequestMapping(value = "quan-tri/hoa-don", method = RequestMethod.POST, params = "update")
	public ModelAndView UpdateBill(@ModelAttribute("bill") BillsDTO bill) {
		_billService.UpdateBill(bill);
		Bill();
		return _mvShare;
	}
	@RequestMapping(value = "quan-tri/hoa-don", method = RequestMethod.POST, params = "delete")
	public ModelAndView DeleteBill(@ModelAttribute("bill") BillsDTO bill) {
		_billService.DeleteBill(bill);
		Bill();
		return _mvShare;
	}
	//BillDetail
	@RequestMapping(value = "quan-tri/hoa-don/{id}")
	public ModelAndView BillDetail(@PathVariable String id) {
		_mvShare.addObject("billDetails", _billService.GetDataBillDetailById(Long.parseLong(id)));
		_mvShare.addObject("products", _productService.GetDataProducts());
		_mvShare.addObject("totalPrice", _billService.GetTotalPrice(Long.parseLong(id)));
		_mvShare.setViewName("admin/bill/billdetail");
		_mvShare.addObject("id", id);
		_mvShare.addObject("billDetail", new BillDetailsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/hoa-don/{id}", method = RequestMethod.POST, params = "addDetail")
	public ModelAndView AddBillDetail(@PathVariable String id,
			@ModelAttribute("billDetail") BillDetailsDTO billDetail) {
		_billService.AddBillDetail(billDetail);
		BillDetail(id);
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/hoa-don/{id}", method = RequestMethod.POST, params = "updateDetail")
	public ModelAndView UpdateBillDetail(@PathVariable String id,
			@ModelAttribute("billDetail") BillDetailsDTO billDetail) {
		_billService.UpdateBillDetail(billDetail);
		BillDetail(id);
		return _mvShare;
	}
	@RequestMapping(value = "quan-tri/hoa-don/{id}", method = RequestMethod.POST, params = "deleteDetail")
	public ModelAndView DeleteBillDetail(@PathVariable String id,
			@ModelAttribute("billDetail") BillDetailsDTO billDetail) {
		_billService.DeleteBillDetail(billDetail);
		BillDetail(id);
		return _mvShare;
	}
}
