package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.CustomersDTO;
import ComputerShop1.DTO.PaginatesDTO;
import ComputerShop1.Service.CustomerServiceImpl;
import ComputerShop1.Service.PaginateServiceImpl;

@Controller
public class AdCustomerController extends AdBaseController {
	@Autowired
	private CustomerServiceImpl _customerService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalCustomersPage = 30;

	@RequestMapping(value = "quan-tri/khach-hang", method = RequestMethod.GET)
	public ModelAndView Customer() {
		_mvShare.clear();
		_mvShare.setViewName("admin/customer/customer");
		int totalData = _customerService.GetDataCustomers().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCustomersPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("customersPaginate",
				_customerService.GetDataCustomersPaginate(null, paginateInfo.getStart(), totalCustomersPage));
		_mvShare.addObject("customers", _customerService.GetDataCustomers());
		_mvShare.addObject("customer", new CustomersDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/khach-hang/{currentPage}", method = RequestMethod.GET)
	public ModelAndView Customer(@PathVariable String currentPage) {
		_mvShare.setViewName("admin/customer/customer");
		int totalData = _customerService.GetDataCustomers().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCustomersPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("customersPaginate",
				_customerService.GetDataCustomersPaginate(null, paginateInfo.getStart(), totalCustomersPage));
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/khach-hang/addorupdate", method = RequestMethod.POST, params = "add")
	public String AddBrand(@ModelAttribute("customer") CustomersDTO customer) {
		_customerService.AddCustomer(customer);
		return "redirect:/quan-tri/khach-hang";
	}

	@RequestMapping(value = "/quan-tri/khach-hang/addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateBrand(@ModelAttribute("customer") CustomersDTO customer) {
		_customerService.UpdateCustomer(customer);
		return "redirect:/quan-tri/khach-hang";
	}

	@RequestMapping(value = "/quan-tri/khach-hang/delete/{id}", method = RequestMethod.GET)
	public String DeleteBrand(@PathVariable("id") long id) {
		_customerService.DeleteCustomer(id);
		return "redirect:/quan-tri/khach-hang";
	}

	@RequestMapping(value = "/quan-tri/khach-hang/search", method = RequestMethod.POST)
	public String SearchCustomer(@RequestParam("keyword") String keyword) {
		_mvShare.clear();
		return "redirect:/quan-tri/khach-hang/search/" + keyword;
	}

	@RequestMapping(value = "/quan-tri/khach-hang/search/{keyword}", method = RequestMethod.GET)
	public ModelAndView SearchCustomer1(@PathVariable("keyword") String keyword) {
		_mvShare.setViewName("admin/customer/customer");
		if (keyword != null) {
			int totalData = _customerService.SearchCustomer(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCustomersPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("customersPaginate",
					_customerService.GetDataCustomersPaginate(keyword, paginateInfo.getStart(), totalCustomersPage));
			_mvShare.addObject("customers", _customerService.SearchCustomer(keyword));
			_mvShare.addObject("customer", new CustomersDTO());
			_mvShare.addObject("keyword",keyword);
		}
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/khach-hang/search/{keyword}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView SearchCustomer(@PathVariable("keyword") String keyword, @PathVariable String currentPage) {
		_mvShare.setViewName("admin/customer/customer");
		if (keyword != null) {
			int totalData = _customerService.SearchCustomer(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalCustomersPage,
					Integer.parseInt(currentPage));
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("customersPaginate",
					_customerService.GetDataCustomersPaginate(keyword, paginateInfo.getStart(), totalCustomersPage));
		}
		return _mvShare;
	}
}
