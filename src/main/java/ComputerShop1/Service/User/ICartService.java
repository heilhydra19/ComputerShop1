package ComputerShop1.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import ComputerShop1.DTO.CartDTO;

@Service
public interface ICartService {
	public HashMap<Long, CartDTO> AddCart(long id, HashMap<Long, CartDTO> cart);
	public HashMap<Long, CartDTO> EditCart(long id, int quanty, HashMap<Long, CartDTO> cart);
	public HashMap<Long, CartDTO> DeleteCart(long id, HashMap<Long, CartDTO> cart);
	public int TotalQuanty(HashMap<Long, CartDTO> cart);
	public double TotalPrice(HashMap<Long, CartDTO> cart);
}
