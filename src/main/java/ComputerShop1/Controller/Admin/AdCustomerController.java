package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.CustomersDTO;
import ComputerShop1.Service.CustomerServiceImpl;

@Controller
public class AdCustomerController extends AdBaseController{
	@Autowired
	private CustomerServiceImpl _customerService;
	
	private ModelAndView View() {
		_mvShare.addObject("customers", _customerService.GetDataCustomers());
		_mvShare.setViewName("admin/customer/customer");
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/khach-hang", method = RequestMethod.GET)
	public ModelAndView Brand() {
		View();
		_mvShare.addObject("customer", new CustomersDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/khach-hang", method = RequestMethod.POST, params = "add")
	public ModelAndView AddBrand(@ModelAttribute("customer") CustomersDTO customer) {
		_customerService.AddCustomer(customer);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/khach-hang", method = RequestMethod.POST, params = "update")
	public ModelAndView UpdateBrand(@ModelAttribute("customer") CustomersDTO customer) {
		_customerService.UpdateCustomer(customer);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/khach-hang", method = RequestMethod.POST, params = "delete")
	public ModelAndView DeleteBrand(@ModelAttribute("customer") CustomersDTO customer) {
		_customerService.DeleteCustomer(customer);
		View();
		return _mvShare;
	}
}
