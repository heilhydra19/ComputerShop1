package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.BrandsDAO;
import ComputerShop1.Entity.Brands;

@Service
public class BrandServiceImpl implements IBrandService{
	@Autowired
	private BrandsDAO brandsDAO;
	
	public List<Brands> GetDataBrands() {
		return brandsDAO.GetDataBrands();
	}
	
	public List<Brands> GetDataBrandsPaginate(String keyword, int start, int totalPage){
		return brandsDAO.GetDataBrandsPaginate(keyword, start, totalPage);
	}

	public int AddBrand(Brands brand) {
		return brandsDAO.AddBrand(brand);
	}

	public int UpdateBrand(Brands brand) {
		return brandsDAO.UpdateBrand(brand);
	}

	public int DeleteBrand(long id) {
		return brandsDAO.DeleteBrand(id);
	}

	public List<Brands> SearchBrand(String keyword) {
		return brandsDAO.SearchBrand(keyword);
	}
}
