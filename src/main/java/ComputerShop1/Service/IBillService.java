package ComputerShop1.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DTO.BillDetailsDTO;
import ComputerShop1.DTO.BillsDTO;
import ComputerShop1.DTO.CartDTO;

@Service
public interface IBillService {
	@Autowired
	public List<BillsDTO> GetDataBills();
	public double GetTotalPrice(long id);
	public List<BillsDTO> SearchBill(String keyword);
	public List<BillsDTO> GetDataBillsPaginate(String keyword, int start, int totalPage);
	public int AddBill(BillsDTO bill);
	public int UpdateBill(BillsDTO bill);
	public int DeleteBill(long id);
	public List<BillDetailsDTO> GetDataBillDetailById(long id);
	public List<BillDetailsDTO> GetDataBillDetailsPaginate(long id, int start, int totalPage);
	public int AddBillDetail(BillDetailsDTO billDetail);
	public int UpdateBillDetail(BillDetailsDTO billDetail);
	public int DeleteBillDetail(long id_bill, long id);
	public void AddBillDetailByCart(HashMap<Long, CartDTO> carts);
}
