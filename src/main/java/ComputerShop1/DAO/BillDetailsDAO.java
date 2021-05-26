package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.BillDetailsDTO;
import ComputerShop1.DTO.BillDetailsDTOMapper;

@Repository
public class BillDetailsDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT a.*, c.name product FROM `billdetails` a, `bills` b, `products` c WHERE a.id_product=c.id AND a.id_bill = b.id ");
		return sql;
	}
	
	private StringBuffer SqlBillDetailById(long id) {
		StringBuffer sql = SqlString();
		sql.append("AND a.id_bill = "+id+" ");
		return sql;
	}
	
	public List<BillDetailsDTO> GetDataBillDetailById(long id) {
		StringBuffer sql = SqlBillDetailById(id);
		return _jdbcTemplate.query(sql.toString(), new BillDetailsDTOMapper());
	}
	
	private String SqlBillDetailsPaginate(long id, int start, int totalPage) {
		StringBuffer sql = SqlBillDetailById(id);
		sql.append(" LIMIT " + (start-1) + ", " + totalPage);
		return sql.toString();
	}

	public List<BillDetailsDTO> GetDataBillDetailsPaginate(long id, int start, int totalPage) {
		StringBuffer sqlGetData = SqlBillDetailById(id);
		List<BillDetailsDTO> listBillDetails = _jdbcTemplate.query(sqlGetData.toString(), new BillDetailsDTOMapper());
		List<BillDetailsDTO> listBillDetailsPaginate = new ArrayList<BillDetailsDTO>();
		if (listBillDetails.size() > 0) {
			String sql = SqlBillDetailsPaginate(id, start, totalPage);
			listBillDetailsPaginate = _jdbcTemplate.query(sql, new BillDetailsDTOMapper());
		}
		return listBillDetailsPaginate;
	}
	
	public double GetDefaultPrice(long id) {
		String sql = "SELECT price FROM `products`WHERE id = '"+id+"'";
		return _jdbcTemplate.queryForObject(sql, Double.class);
	}
	
	public double GetTotalPrice(long id) {
		String sql = "SELECT COALESCE(SUM(amount * price),0) TotalPrice FROM `billdetails` WHERE id_bill = '"+id+"'";
		return _jdbcTemplate.queryForObject(sql, Double.class);
	}
	
	public int AddBillDetail(BillDetailsDTO billDetail) {
		String sql = "INSERT INTO `billdetails`(`id_product`, `id_bill`, `amount`, `price`) "
				+ "VALUES ('"+billDetail.getId_product()+"','"+billDetail.getId_bill()+"','"+billDetail.getAmount()+"',"
				+ "CASE WHEN "+billDetail.getPrice()+" = 0 THEN '"+GetDefaultPrice(billDetail.getId_product())+"' ELSE '"+billDetail.getPrice()+"' END)";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateBillDetail(BillDetailsDTO billDetail) {
		String sql = "UPDATE `billdetails` SET `id_product`='"+billDetail.getId_product()+"',`amount`='"+billDetail.getAmount()+"',"
				+ "`price`='"+billDetail.getPrice()+"' WHERE `id_bill`='"+billDetail.getId_bill()+"' AND `id` = '"+billDetail.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteBillDetail(long id_bill, long id) {
		String sql = "DELETE FROM `billdetails` WHERE `id_bill`='"+id_bill+"' AND `id` = '"+id+"'";
		return _jdbcTemplate.update(sql);
	}
}
