package ComputerShop1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ComputerShop1.Entity.Brands;

@Service
public interface IBrandService {
	public List<Brands> GetDataBrands();
}
