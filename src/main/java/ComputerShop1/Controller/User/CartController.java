package ComputerShop1.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ComputerShop1.DTO.BillsDTO;
import ComputerShop1.DTO.CartDTO;
import ComputerShop1.DTO.UsersDTO;
import ComputerShop1.Service.BillServiceImpl;
import ComputerShop1.Service.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private BillServiceImpl billService = new BillServiceImpl();

	@RequestMapping(value = "gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("categories", _homeService.GetDataCategories());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}

	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable long id,
			@PathVariable int quanty) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDTO>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		BillsDTO bills = new BillsDTO();
		UsersDTO loginInfo = (UsersDTO) session.getAttribute("LoginInfo");
		if (loginInfo != null) {
			bills.setId_user(loginInfo.getId_user());
		}
		_mvShare.addObject("bills", bills);
		return _mvShare;
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request, HttpSession session,
			@ModelAttribute("bills") BillsDTO bill) {
		HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("Cart");
		if (billService.AddBill(bill) > 0) {
			billService.AddBillDetailByCart(cart);
		}
		session.removeAttribute("Cart");
		session.removeAttribute("TotalQuantyCart");
		session.removeAttribute("TotalPriceCart");
		return "redirect:gio-hang";
	}
}
