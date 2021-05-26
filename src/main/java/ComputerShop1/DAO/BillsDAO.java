package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.BillsDTO;
import ComputerShop1.DTO.BillsDTOMapper;

@Repository
public class BillsDAO extends BaseDAO {
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM `bills` a, `users` b WHERE a.id_user = b.id ");
		return sql;
	}

	public List<BillsDTO> GetDataBills() {
		StringBuffer sql = SqlString();
		sql.append("ORDER BY a.id DESC ");
		return _jdbcTemplate.query(sql.toString(), new BillsDTOMapper());
	}

	private String SqlBillsPaginate(String keyword, int start, int totalPage) {
		StringBuffer sql = SqlString();
		if (keyword != null) {
			sql.append("and a.id like '%" + keyword + "%' or b.name like '%" + keyword + "%' or a.address like '%"
					+ keyword + "%' ");
		}
		sql.append("ORDER BY a.id DESC LIMIT " + (start - 1) + ", " + totalPage);
		return sql.toString();
	}

	public List<BillsDTO> GetDataBillsPaginate(String keyword, int start, int totalPage) {
		StringBuffer sqlGetData = SqlString();
		List<BillsDTO> listBills = _jdbcTemplate.query(sqlGetData.toString(), new BillsDTOMapper());
		List<BillsDTO> listBillsPaginate = new ArrayList<BillsDTO>();
		if (listBills.size() > 0) {
			String sql = SqlBillsPaginate(keyword, start, totalPage);
			listBillsPaginate = _jdbcTemplate.query(sql, new BillsDTOMapper());
		}
		return listBillsPaginate;
	}

	public List<BillsDTO> SearchBill(String keyword) {
		StringBuffer sql = SqlString();
		sql.append("and a.id like '%" + keyword + "%' or b.name like '%" + keyword + "%' or a.address like '%" + keyword
				+ "%' ORDER BY a.id DESC ");
		return _jdbcTemplate.query(sql.toString(), new BillsDTOMapper());
	}

	public long GetIDLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills");
		return _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
	}

	public int AddBill(BillsDTO bill) {
		String sql = "INSERT INTO `bills`(`id_user`, `address`) VALUES ('" + bill.getId_user() + "',N'"
				+ bill.getAddress() + "')";
		return _jdbcTemplate.update(sql);
	}

	public int UpdateBill(BillsDTO bill) {
		String sql = "UPDATE `bills` SET `id_user`='" + bill.getId_user() + "'," + "`address`= CASE WHEN '"
				+ bill.getAddress() + "' = '' THEN `address` ELSE N'" + bill.getAddress() + "' END WHERE `id`='"
				+ bill.getId() + "'";
		return _jdbcTemplate.update(sql);
	}

	public int DeleteBill(long id) {
		String sql = "DELETE FROM `bills` WHERE `id` = '" + id + "'";
		return _jdbcTemplate.update(sql);
	}
}
