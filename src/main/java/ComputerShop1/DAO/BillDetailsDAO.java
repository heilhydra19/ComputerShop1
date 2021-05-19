package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.BillDetailsDTO;
import ComputerShop1.DTO.BillDetailsDTOMapper;

@Repository
public class BillDetailsDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT a.*, c.name product, c.price sellprice FROM `billdetails` a, `bills` b, `products` c WHERE a.id_product=c.id AND a.id_bill = b.id ");
		return sql;
	}
	
	public List<BillDetailsDTO> GetDataBillDetailById(long id) {
		StringBuffer sql = SqlString();
		sql.append("AND a.id_bill = "+id+" ");
		return _jdbcTemplate.query(sql.toString(), new BillDetailsDTOMapper());
	}
	
	public int AddBillDetail(BillDetailsDTO billDetail) {
		String sql = "INSERT INTO `billdetails`(`id_product`, `id_bill`, `amount`, `price`) "
				+ "VALUES ('"+billDetail.getId_product()+"','"+billDetail.getId_bill()+"','"+billDetail.getAmount()+"','"+billDetail.getPrice()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateBillDetail(BillDetailsDTO billDetail) {
		String sql = "UPDATE `billdetails` SET `id_product`='"+billDetail.getId_product()+"',`amount`='"+billDetail.getAmount()+"',"
				+ "`price`='"+billDetail.getPrice()+"' WHERE `id_bill`='"+billDetail.getId_bill()+"' AND `id` = '"+billDetail.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteBillDetail(BillDetailsDTO billDetail) {
		String sql = "DELETE FROM `billdetails` WHERE `id_bill`='"+billDetail.getId_bill()+"' AND `id` = '"+billDetail.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
}
