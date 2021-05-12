package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.Service.UserServiceImpl;

@Controller
public class AdUserController extends AdBaseController{
	@Autowired
	private UserServiceImpl _userService;
	
	private ModelAndView View() {
		_mvShare.addObject("users", _userService.GetDataUsers());
		_mvShare.addObject("roles", _userService.GetDataRoles());
		_mvShare.setViewName("admin/user/user");
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/nguoi-dung", method = RequestMethod.GET)
	public ModelAndView User() {
		View();
		_mvShare.addObject("user", new UsersDTO());
		_mvShare.addObject("account", new UsersDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/nguoi-dung", method = RequestMethod.POST, params = "adduser")
	public ModelAndView AddUser(@ModelAttribute("user") UsersDTO user) {
		_userService.AddUser(user);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/nguoi-dung", method = RequestMethod.POST, params = "updateuser")
	public ModelAndView UpdateUser(@ModelAttribute("user") UsersDTO user) {
		_userService.UpdateUser(user);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/nguoi-dung", method = RequestMethod.POST, params = "deleteuser")
	public ModelAndView DeleteUser(@ModelAttribute("user") UsersDTO user) {
		_userService.DeleteUser(user);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/nguoi-dung", method = RequestMethod.POST, params = "addaccount")
	public ModelAndView AddAccount(@ModelAttribute("account") UsersDTO user) {
		_userService.AddAccount(user);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/nguoi-dung", method = RequestMethod.POST, params = "updateaccount")
	public ModelAndView UpdateAccount(@ModelAttribute("account") UsersDTO user) {
		_userService.UpdateAccount(user);
		View();
		return _mvShare;
	}
	
	@RequestMapping(value = "quan-tri/nguoi-dung", method = RequestMethod.POST, params = "deleteaccount")
	public ModelAndView DeleteAccount(@ModelAttribute("account") UsersDTO user) {
		_userService.DeleteAccount(user);
		View();
		return _mvShare;
	}
}
