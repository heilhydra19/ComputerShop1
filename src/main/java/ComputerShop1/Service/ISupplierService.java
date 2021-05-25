package ComputerShop1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ComputerShop1.Entity.Suppliers;

@Service
public interface ISupplierService {
	public List<Suppliers> GetDataSuppliers();
	public List<Suppliers> SearchSupplier(String keyword);
	public int AddSupplier(Suppliers supplier);
	public int UpdateSupplier(Suppliers supplier);
	public int DeleteSupplier(long id);
}
