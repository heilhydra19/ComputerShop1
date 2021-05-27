package ComputerShop1.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.PaginatesDTO;
import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.Service.PaginateServiceImpl;
import ComputerShop1.Service.UserServiceImpl;

@Controller

public class AdUserController extends AdBaseController {
	@Autowired
	private UserServiceImpl _userService;
	@Autowired
	private PaginateServiceImpl paginateService;

	private int totalUsersPage = 30;

	@RequestMapping(value = "quan-tri/nguoi-dung", method = RequestMethod.GET)
	public ModelAndView User() {
		_mvShare.clear();
		_mvShare.addObject("users", _userService.GetDataUsers());
		_mvShare.addObject("roles", _userService.GetDataRoles());
		_mvShare.setViewName("admin/user/user");
		int totalData = _userService.GetDataUsers().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalUsersPage, 1);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("usersPaginate",
				_userService.GetDataUsersPaginate(null, paginateInfo.getStart(), totalUsersPage));
		_mvShare.addObject("user", new UsersDTO());
		_mvShare.addObject("account", new UsersDTO());
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/nguoi-dung/{currentPage}", method = RequestMethod.GET)
	public ModelAndView User(@PathVariable String currentPage) {
		_mvShare.setViewName("admin/user/user");
		int totalData = _userService.GetDataUsers().size();
		PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalUsersPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("usersPaginate",
				_userService.GetDataUsersPaginate(null, paginateInfo.getStart(), totalUsersPage));
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/nguoi-dung/addorupdate", method = RequestMethod.POST, params = "add")
	public String AddUser(@ModelAttribute("user") UsersDTO user) {
		_userService.AddUser(user);
		_userService.AddAccount(user);
		return "redirect:/quan-tri/nguoi-dung";
	}

	@RequestMapping(value = "/quan-tri/nguoi-dung/addorupdate", method = RequestMethod.POST, params = "update")
	public String UpdateUser(@ModelAttribute("user") UsersDTO user) {
		_userService.UpdateUser(user);
		_userService.UpdateAccount(user);
		return "redirect:/quan-tri/nguoi-dung";
	}

	@RequestMapping(value = "/quan-tri/nguoi-dung/deleteAccount/{id}", method = RequestMethod.GET)
	public String DeleteAccount(@PathVariable("id") long id) {
		_userService.DeleteAccount(id);
		return "redirect:/quan-tri/nguoi-dung";
	}

	@RequestMapping(value = "/quan-tri/nguoi-dung/search", method = RequestMethod.POST)
	public String SearchUser(@RequestParam("keyword") String keyword) {
		_mvShare.clear();
		return "redirect:/quan-tri/nguoi-dung/search/" + keyword;
	}
	
	@RequestMapping(value = "/quan-tri/nguoi-dung/search/{keyword}", method = RequestMethod.GET)
	public ModelAndView SearchUser1(@PathVariable("keyword") String keyword) {
		if (keyword != null) {
			_mvShare.addObject("users", _userService.GetDataUsers());
			_mvShare.addObject("roles", _userService.GetDataRoles());
			_mvShare.setViewName("admin/user/user");
			int totalData = _userService.SearchUser(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalUsersPage, 1);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("usersPaginate",
					_userService.GetDataUsersPaginate(keyword, paginateInfo.getStart(), totalUsersPage));
			_mvShare.addObject("user", new UsersDTO());
			_mvShare.addObject("account", new UsersDTO());
			_mvShare.addObject("keyword",keyword);
		}
		return _mvShare;
	}

	@RequestMapping(value = "/quan-tri/nguoi-dung/search/{keyword}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView SearchUser(@PathVariable("keyword") String keyword, @PathVariable String currentPage) {
		if (keyword != null) {
			_mvShare.setViewName("admin/user/user");
			int totalData = _userService.SearchUser(keyword).size();
			PaginatesDTO paginateInfo = paginateService.GetInfoPaginates(totalData, totalUsersPage,
					Integer.parseInt(currentPage));
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("usersPaginate",
					_userService.GetDataUsersPaginate(keyword, paginateInfo.getStart(), totalUsersPage));
		}
		return _mvShare;
	}
}
