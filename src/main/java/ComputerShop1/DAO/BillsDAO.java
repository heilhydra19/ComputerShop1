package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.BillsDTO;
import ComputerShop1.DTO.BillsDTOMapper;

@Repository
public class BillsDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT * FROM `bills` a, `users` b WHERE a.id_user = b.id ");
		return sql;
	}
	
	public List<BillsDTO> GetDataBills(){
		StringBuffer sql = SqlString();
		sql.append("ORDER BY a.id DESC ");
		return _jdbcTemplate.query(sql.toString(), new BillsDTOMapper());
	}
	
	public int AddBill(BillsDTO bill) {
		String sql = "INSERT INTO `bills`(`id_user`, `address`) VALUES ('"+bill.getId_user()+"','"+bill.getAddress()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateBill(BillsDTO bill) {
		String sql = "UPDATE `bills` SET `id_user`='"+bill.getId_user()+"',"
				+ "`address`= CASE WHEN '"+bill.getAddress()+"' = '' THEN `address` ELSE '"+bill.getAddress()+"' END WHERE `id`='"+bill.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteBill(BillsDTO bill) {
		String sql = "DELETE FROM `bills` WHERE `id` = '"+bill.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
}
