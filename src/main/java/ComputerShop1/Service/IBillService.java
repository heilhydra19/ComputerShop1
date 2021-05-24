package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DTO.BillDetailsDTO;
import ComputerShop1.DTO.BillsDTO;

@Service
public interface IBillService {
	@Autowired
	public List<BillsDTO> GetDataBills();
	public double GetTotalPrice(long id);
	public int AddBill(BillsDTO bill);
	public int UpdateBill(BillsDTO bill);
	public int DeleteBill(long id);
	public List<BillDetailsDTO> GetDataBillDetailById(long id);
	public int AddBillDetail(BillDetailsDTO billDetail);
	public int UpdateBillDetail(BillDetailsDTO billDetail);
	public int DeleteBillDetail(long id_bill, long id);
}