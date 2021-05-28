package ComputerShop1.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.MapperSuppliers;
import ComputerShop1.Entity.Suppliers;

@Repository
public class SuppliersDAO extends BaseDAO {
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM suppliers where 1 ");
		return sql;
	}

	public List<Suppliers> GetDataSuppliers() {
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new MapperSuppliers());
	}

	private String SqlSuppliersPaginate(String keyword, int start, int totalPage) {
		StringBuffer sql = SqlString();
		if (keyword != null) {
			sql.append("and id like '%" + keyword + "%' or name like '%" + keyword + "%' or phone like '%" + keyword
					+ "%' or email like '%" + keyword + "%'");
		}
		sql.append(" LIMIT " + (start - 1) + ", " + totalPage);
		return sql.toString();
	}

	public List<Suppliers> GetDataSuppliersPaginate(String keyword, int start, int totalPage) {
		StringBuffer sqlGetData = SqlString();
		List<Suppliers> listSuppliers = _jdbcTemplate.query(sqlGetData.toString(), new MapperSuppliers());
		List<Suppliers> listSuppliersPaginate = new ArrayList<Suppliers>();
		if (listSuppliers.size() > 0) {
			String sql = SqlSuppliersPaginate(keyword, start, totalPage);
			listSuppliersPaginate = _jdbcTemplate.query(sql, new MapperSuppliers());
		}
		return listSuppliersPaginate;
	}

	public List<Suppliers> SearchSupplier(String keyword) {
		StringBuffer sql = SqlString();
		sql.append("and id like '%" + keyword + "%' or name like '%" + keyword + "%' or phone like '%" + keyword
				+ "%' or email like '%" + keyword + "%'");
		return _jdbcTemplate.query(sql.toString(), new MapperSuppliers());
	}

	public int AddSupplier(Suppliers supplier) {
		String sql = "INSERT INTO `suppliers`(`name`, `phone`, `email`, `img`) " + "VALUES (N'" + supplier.getName()
				+ "','" + supplier.getPhone() + "','" + supplier.getEmail() + "','" + supplier.getImg() + "') ";
		return _jdbcTemplate.update(sql);
	}

	public int UpdateSupplier(Suppliers supplier) {
		String sql = "UPDATE `suppliers` SET `name`= CASE WHEN '" + supplier.getName() + "' = '' THEN `name` ELSE N'"
				+ supplier.getName() + "' END,\r\n" + "		`phone`=CASE WHEN '" + supplier.getPhone()
				+ "' = '' THEN `phone` ELSE '" + supplier.getPhone() + "' END,\r\n" + "        `email`=CASE WHEN '"
				+ supplier.getEmail() + "' = '' THEN `email` ELSE '" + supplier.getEmail() + "' END,\r\n"
				+ "        `img`=CASE WHEN '" + supplier.getImg() + "' = '' THEN `img` ELSE '" + supplier.getImg()
				+ "' END \r\n" + "        WHERE `id`='" + supplier.getId() + "'";
		return _jdbcTemplate.update(sql);
	}

	public int DeleteSupplier(long id) {
		String sql = "DELETE FROM `suppliers` WHERE `id` = '" + id + "'";
		return _jdbcTemplate.update(sql);
	}
}
