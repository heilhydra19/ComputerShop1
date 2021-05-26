package ComputerShop1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ComputerShop1.Entity.Brands;

@Service
public interface IBrandService {
	public List<Brands> GetDataBrands();
	public List<Brands> GetDataBrandsPaginate(String keyword, int start, int totalPage);
	public List<Brands> SearchBrand(String keyword);
	public int AddBrand(Brands brand);
	public int UpdateBrand(Brands brand);
	public int DeleteBrand(long id);
}
