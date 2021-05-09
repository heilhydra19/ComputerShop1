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
}
