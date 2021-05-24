package ComputerShop1.DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.CartDTO;
import ComputerShop1.DTO.ProductsDTO;

@Repository
public class CartDAO extends BaseDAO{
	@Autowired
	private ProductsDAO productsDAO;
	
	public HashMap<Long, CartDTO> AddCart(long id, HashMap<Long, CartDTO> cart) {
		CartDTO itemCart = new CartDTO();
		ProductsDTO product = productsDAO.FindProductByID(id);
		if(product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(itemCart.getQuanty() + 1);
			itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
		}
		else {
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}
	public HashMap<Long, CartDTO> EditCart(long id, int quanty, HashMap<Long, CartDTO> cart) {
		if(cart == null) {
			return cart;
		}
		CartDTO itemCart = new CartDTO();
		if(cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			double totalPrice = quanty * itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}
	
	public HashMap<Long, CartDTO> DeleteCart(long id, HashMap<Long, CartDTO> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}
	
	public int TotalQuanty(HashMap<Long, CartDTO> cart) {
		int totalQuanty = 0;
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuanty();
		}
		return totalQuanty;
	}
	
	public double TotalPrice(HashMap<Long, CartDTO> cart) {
		double totalPrice = 0;
		for(Map.Entry<Long, CartDTO> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
