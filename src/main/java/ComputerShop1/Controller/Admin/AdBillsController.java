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
import ComputerShop1.DTO.PaginatesDTO;
import ComputerShop1.Service.BillServiceImpl;
import ComputerShop1.Service.PaginateServiceImpl;
import ComputerShop1.Service.UserServiceImpl;

@Controller

public class AdBillsController extends AdBaseController {
	@Autowired
	private BillServiceImpl _billService;
	@Autowired
	private UserServiceImpl _userService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalBillsPage = 30;

	@RequestMapping(value = "quan-tri/hoa-don", method = RequestMethod.GET)
	public ModelAndView Bill() {
		_mvShare.clear();
		int totalData = _billService.GetDataBills().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalBillsPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("billsPaginate",
				_billService.GetDataBillsPaginate(null, paginateInfo.getStart(), totalBillsPage));
		_mvShare.addObject("bills", _billService.GetDataBills());
		_mvShare.addObject("users", _userService.GetDataUsers());
		_mvShare.setViewName("admin/bill/bill");
		_mvShare.addObject("bill", new BillsDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/hoa-don/{currentPage}", method = RequestMethod.GET)
	public ModelAndView Bill(@PathVariable String currentPage) {
		int totalData = _billService.GetDataBills().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalBillsPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("billsPaginate",
				_billService.GetDataBillsPaginate(null, paginateInfo.getStart(), totalBillsPage));
		_mvShare.setViewName("admin/bill/bill");
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/hoa-don/addorupdate", method = RequestMethod.POST, params = "add")
	public String AddBill(@ModelAttribute("bill") BillsDTO bill) {
		_billService.AddBill(bill);
		return "redirect:/quan-tri/hoa-don";
	}

	@RequestMapping(value = "/quan-tri/hoa-don/addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateBill(@ModelAttribute("bill") BillsDTO bill) {
		_billService.UpdateBill(bill);
		return "redirect:/quan-tri/hoa-don";
	}

	@RequestMapping(value = "/quan-tri/hoa-don/delete/{id}", method = RequestMethod.GET)
	public String DeleteBill(@PathVariable("id") long id) {
		_billService.DeleteBill(id);
		return "redirect:/quan-tri/hoa-don";
	}

	@RequestMapping(value = "/quan-tri/hoa-don/search", method = RequestMethod.POST)
	public String SearchBill(@RequestParam("keyword") String keyword) {
		_mvShare.clear();
		return "redirect:/quan-tri/hoa-don/search/" + keyword;
	}

	@RequestMapping(value = "/quan-tri/hoa-don/search/{keyword}", method = RequestMethod.GET)
	public ModelAndView SearchBill1(@PathVariable("keyword") String keyword) {
		if (keyword != null) {
			int totalData = _billService.SearchBill(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalBillsPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("billsPaginate",
					_billService.GetDataBillsPaginate(keyword, paginateInfo.getStart(), totalBillsPage));
			_mvShare.addObject("bills", _billService.GetDataBills());
			_mvShare.addObject("users", _userService.GetDataUsers());
			_mvShare.setViewName("admin/bill/bill");
			_mvShare.addObject("bill", new BillsDTO());
			_mvShare.addObject("keyword",keyword);
		}
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/hoa-don/search/{keyword}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView SearchBill(@PathVariable("keyword") String keyword, @PathVariable String currentPage) {
		if (keyword != null) {
			int totalData = _billService.SearchBill(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalBillsPage,
					Integer.parseInt(currentPage));
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("billsPaginate",
					_billService.GetDataBillsPaginate(keyword, paginateInfo.getStart(), totalBillsPage));
			_mvShare.setViewName("admin/bill/bill");
		}
		return _mvShare;
	}
}
