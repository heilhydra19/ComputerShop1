package ComputerShop1.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import ComputerShop1.Entity.MapperRoles;
import ComputerShop1.Entity.Roles;

@Repository
public class RolesDAO extends BaseDAO{
	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM roles ");
		return sql;
	}
	
	public List<Roles> GetDataRoles(){
		StringBuffer sql = SqlString();
		return _jdbcTemplate.query(sql.toString(), new MapperRoles());
	}
}
