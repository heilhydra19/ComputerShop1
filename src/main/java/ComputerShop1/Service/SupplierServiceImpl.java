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

	public int AddSupplier(Suppliers supplier) {
		return suppliersDAO.AddSupplier(supplier);
	}

	public int UpdateSupplier(Suppliers supplier) {
		return suppliersDAO.UpdateSupplier(supplier);
	}

	public int DeleteSupplier(Suppliers supplier) {
		return suppliersDAO.DeleteSupplier(supplier);
	}
	
}
