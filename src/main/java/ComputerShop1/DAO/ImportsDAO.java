package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.DTO.ImportsDTO;
import ComputerShop1.DTO.ImportsDTOMapper;

@Repository
public class ImportsDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT * FROM `imports` a, `suppliers` b WHERE a.id_supplier = b.id ");
		return sql;
	}
	
	public List<ImportsDTO> GetDataImports(){
		StringBuffer sql = SqlString();
		sql.append("ORDER BY a.id DESC ");
		return _jdbcTemplate.query(sql.toString(), new ImportsDTOMapper());
	}
	
	public List<ImportsDTO> SearchImport(String keyword){
		StringBuffer sql = SqlString();
		sql.append("and a.id like '%"+keyword+"%' or b.name like '%"+keyword+"%' ORDER BY a.id DESC ");
		return _jdbcTemplate.query(sql.toString(), new ImportsDTOMapper());
	}
	
	public int AddImport(ImportsDTO imports) {
		String sql = "INSERT INTO `imports`(`id_supplier`) VALUES ('"+imports.getId_supplier()+"')";
		return _jdbcTemplate.update(sql);
	}
	
	public int UpdateImport(ImportsDTO imports) {
		String sql = "UPDATE `imports` SET `id_supplier`='"+imports.getId_supplier()+"' WHERE `id`='"+imports.getId()+"'";
		return _jdbcTemplate.update(sql);
	}
	
	public int DeleteImport(long id) {
		String sql = "DELETE FROM `imports` WHERE `id` = '"+id+"'";
		return _jdbcTemplate.update(sql);
	}
}
