package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.Service.UserServiceImpl;

@Controller
@RequestMapping(value = "quan-tri/nguoi-dung")
public class AdUserController extends AdBaseController{
	@Autowired
	private UserServiceImpl _userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView User() {
		_mvShare.addObject("users", _userService.GetDataUsers());
		_mvShare.addObject("roles", _userService.GetDataRoles());
		_mvShare.setViewName("admin/user/user");
		_mvShare.addObject("user", new UsersDTO());
		_mvShare.addObject("account", new UsersDTO());
		return _mvShare;
	}

	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "add")
	public String AddUser(@ModelAttribute("user") UsersDTO user) {
		_userService.AddUser(user);
		_userService.AddAccount(user);
		return "redirect:/quan-tri/nguoi-dung";
	}
	
	@RequestMapping(value = "addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateUser(@ModelAttribute("user") UsersDTO user) {
		_userService.UpdateUser(user);
		_userService.UpdateAccount(user);
		return "redirect:/quan-tri/nguoi-dung";
	}
	
	@RequestMapping(value = "deleteAccount/{id}", method = RequestMethod.GET)
	public String DeleteAccount(@PathVariable("id") long id) {
		_userService.DeleteAccount(id);
		return "redirect:/quan-tri/nguoi-dung";
	}
}
