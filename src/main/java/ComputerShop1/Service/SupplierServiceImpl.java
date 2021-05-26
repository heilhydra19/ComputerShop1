package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.SuppliersDAO;
import ComputerShop1.Entity.Suppliers;

@Service
public class SupplierServiceImpl implements ISupplierService{
	@Autowired
	private SuppliersDAO suppliersDAO;
	
	public List<Suppliers> GetDataSuppliers() {
		return suppliersDAO.GetDataSuppliers();
	}
	
	public List<Suppliers> GetDataSuppliersPaginate(String keyword, int start, int totalPage){
		return suppliersDAO.GetDataSuppliersPaginate(keyword, start, totalPage);
	}

	public List<Suppliers> SearchSupplier(String keyword){
		return suppliersDAO.SearchSupplier(keyword);
	}
	
	public int AddSupplier(Suppliers supplier) {
		return suppliersDAO.AddSupplier(supplier);
	}

	public int UpdateSupplier(Suppliers supplier) {
		return suppliersDAO.UpdateSupplier(supplier);
	}

	public int DeleteSupplier(long id) {
		return suppliersDAO.DeleteSupplier(id);
	}
	
}
