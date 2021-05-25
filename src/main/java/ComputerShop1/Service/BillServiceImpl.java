package ComputerShop1.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.BillDetailsDAO;
import ComputerShop1.DAO.BillsDAO;
import ComputerShop1.DTO.BillDetailsDTO;
import ComputerShop1.DTO.BillsDTO;
import ComputerShop1.DTO.CartDTO;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	private BillsDAO billsDAO;
	@Autowired
	private BillDetailsDAO billDetailsDAO;

	public List<BillsDTO> GetDataBills() {
		return billsDAO.GetDataBills();
	}

	public List<BillsDTO> SearchBill(String keyword){
		return billsDAO.SearchBill(keyword);
	}
	
	public double GetTotalPrice(long id) {
		return billDetailsDAO.GetTotalPrice(id);
	}

	public int AddBill(BillsDTO bill) {
		return billsDAO.AddBill(bill);
	}

	public int UpdateBill(BillsDTO bill) {
		return billsDAO.UpdateBill(bill);
	}

	public int DeleteBill(long id) {
		return billsDAO.DeleteBill(id);
	}

	public List<BillDetailsDTO> GetDataBillDetailById(long id) {
		return billDetailsDAO.GetDataBillDetailById(id);
	}

	public int AddBillDetail(BillDetailsDTO billDetail) {
		return billDetailsDAO.AddBillDetail(billDetail);
	}

	public int UpdateBillDetail(BillDetailsDTO billDetail) {
		return billDetailsDAO.UpdateBillDetail(billDetail);
	}

	public int DeleteBillDetail(long id_bill, long id) {
		return billDetailsDAO.DeleteBillDetail(id_bill, id);
	}

	public void AddBillDetailByCart(HashMap<Long, CartDTO> carts) {
		long idBill = billsDAO.GetIDLastBills();
		for (Map.Entry<Long, CartDTO> itemCart : carts.entrySet()) {
			BillDetailsDTO billDetail = new BillDetailsDTO();
			billDetail.setId_bill(idBill);
			billDetail.setId_product(itemCart.getValue().getProduct().getId());
			billDetailsDAO.AddBillDetail(billDetail);
		}
	}
}
