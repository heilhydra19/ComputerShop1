package ComputerShop1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ComputerShop1.Entity.Brands;

@Service
public interface IBrandService {
	public List<Brands> GetDataBrands();
	public int AddBrand(Brands brand);
	public int UpdateBrand(Brands brand);
	public int DeleteBrand(long id);
}
