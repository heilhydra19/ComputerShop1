package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.ImportDetailsDTO;
import ComputerShop1.DTO.ImportDetailsDTOMapper;

@Repository
public class ImportDetailsDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT a.*, c.name product FROM `importdetails` a, `imports` b, `products` c WHERE a.id_product=c.id AND a.id_import = b.id ");
		return sql;
	}
	
	public List<ImportDetailsDTO> GetDataImportDetailById(long id) {
		StringBuffer sql = SqlString();
		sql.append("AND a.id_import = "+id+" ");
		return _jdbcTemplate.query(sql.toString(), new ImportDetailsDTOMapper());
	}
	
	public double GetTotalPrice(long id) {
		String sql = "SELECT COALESCE(SUM(amount * price),0) TotalPrice FROM `importdetails` WHERE id_import = '"+id+"'";
		return _jdbcTemplate.queryForObject(sql, Double.class);
	}
	
	public int AddImportDetail(ImportDetailsDTO importDetail) {
		String sql = "INSERT INTO `importdetails`(`id_product`, `id_import`, `amount`, `price`) "
				+ "VALUES ('"+importDetail.getId_product()+"','"+importDetail.getId_import()+"','"+importDetail.getAmount()+"','"+importDetail.getPrice()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateImportDetail(ImportDetailsDTO importDetail) {
		String sql = "UPDATE `importdetails` SET `id_product`='"+importDetail.getId_product()+"',`amount`='"+importDetail.getAmount()+"',"
				+ "`price`='"+importDetail.getPrice()+"' WHERE `id_import`='"+importDetail.getId_import()+"' AND `id` = '"+importDetail.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteImportDetail(long id_import, long id) {
		String sql = "DELETE FROM `importdetails` WHERE `id_import`='"+id_import+"' AND `id` = '"+id+"'";
		return _jdbcTemplate.update(sql);
	}
}
