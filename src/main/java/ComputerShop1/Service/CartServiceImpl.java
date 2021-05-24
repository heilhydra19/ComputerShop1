package ComputerShop1.Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.CartDAO;
import ComputerShop1.DTO.CartDTO;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private CartDAO cartDao = new CartDAO();

	public HashMap<Long, CartDTO> AddCart(long id, HashMap<Long, CartDTO> cart) {
		return cartDao.AddCart(id, cart);
	}

	public HashMap<Long, CartDTO> EditCart(long id, int quanty, HashMap<Long, CartDTO> cart) {
		return cartDao.EditCart(id, quanty, cart);
	}

	public HashMap<Long, CartDTO> DeleteCart(long id, HashMap<Long, CartDTO> cart) {
		return cartDao.DeleteCart(id, cart);
	}

	public int TotalQuanty(HashMap<Long, CartDTO> cart) {
		return cartDao.TotalQuanty(cart);
	}

	public double TotalPrice(HashMap<Long, CartDTO> cart) {
		return cartDao.TotalPrice(cart);
	}
	
}
