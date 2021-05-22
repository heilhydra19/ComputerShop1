package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.CustomersDTO;
import ComputerShop1.Service.CustomerServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/khach-hang")
public class AdCustomerController extends AdBaseController{
	@Autowired
	private CustomerServiceImpl _customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView Brand() {
		_mvShare.addObject("customers", _customerService.GetDataCustomers());
		_mvShare.setViewName("admin/customer/customer");
		_mvShare.addObject("customer", new CustomersDTO());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddBrand(@ModelAttribute("customer") CustomersDTO customer) {
		_customerService.AddCustomer(customer);
		return "redirect:/quan-tri/khach-hang";
	}
	
	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateBrand(@ModelAttribute("customer") CustomersDTO customer) {
		_customerService.UpdateCustomer(customer);
		return "redirect:/quan-tri/khach-hang";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String DeleteBrand(@PathVariable("id") long id) {
		_customerService.DeleteCustomer(id);
		return "redirect:/quan-tri/khach-hang";
	}
}
