package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.BillsDTO;
import ComputerShop1.Service.BillServiceImpl;
import ComputerShop1.Service.UserServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/hoa-don")
public class AdBillsController extends AdBaseController {
	@Autowired
	private BillServiceImpl _billService;

	@Autowired
	private UserServiceImpl _userService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Bill() {
		_mvShare.addObject("bills", _billService.GetDataBills());
		_mvShare.addObject("users", _userService.GetDataUsers());
		_mvShare.setViewName("admin/bill/bill");
		_mvShare.addObject("bill", new BillsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddBill(@ModelAttribute("bill") BillsDTO bill) {
		_billService.AddBill(bill);
		return "redirect:/quan-tri/hoa-don";
	}
	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateBill(@ModelAttribute("bill") BillsDTO bill) {
		_billService.UpdateBill(bill);
		return "redirect:/quan-tri/hoa-don";
	}
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String DeleteBill(@PathVariable("id") long id) {
		_billService.DeleteBill(id);
		return "redirect:/quan-tri/hoa-don";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView SearchBill(@RequestParam("keyword") String keyword) {
		if(keyword != null) {
			_mvShare.addObject("bills", _billService.SearchBill(keyword));
		}
		else {
			_mvShare.addObject("bills", _billService.GetDataBills());
		}
		_mvShare.addObject("users", _userService.GetDataUsers());
		_mvShare.setViewName("admin/bill/bill");
		return _mvShare;
	}
}
