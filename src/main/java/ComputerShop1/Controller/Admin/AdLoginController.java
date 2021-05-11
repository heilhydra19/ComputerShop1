package ComputerShop1.Controller.Admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.Service.UserServiceImpl;

@Controller
public class AdLoginController extends AdBaseController {
	@Autowired
	private UserServiceImpl accountService;

	@RequestMapping(value = "/quan-tri/", method = RequestMethod.GET)
	public ModelAndView Index(HttpSession session) {
		_mvShare.addObject("account", new UsersDTO());
		_mvShare.setViewName("admin/index");
		session.removeAttribute("LoginInfo");
		session.removeAttribute("LoginEmplInfo");
		return _mvShare;
	}

	@RequestMapping(value = "quan-tri/san-pham", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("account") UsersDTO account) {
		account = accountService.FindAccountByUsername(account);
		if (account != null) {
			if (account.getId_role() == 1) {
				_mvShare.setViewName("redirect:san-pham");
				session.setAttribute("LoginInfo", account);
			}
			else if(account.getId_role() == 2) {
				_mvShare.setViewName("redirect:san-pham");
				session.setAttribute("LoginEmplInfo", account);
			}
			else {
				_mvShare.setViewName("redirect:/quan-tri/");
			}
		} else {
			_mvShare.setViewName("redirect:/quan-tri/");
		}
		return _mvShare;
	}
}
