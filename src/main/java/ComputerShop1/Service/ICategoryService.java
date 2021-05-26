package ComputerShop1.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ComputerShop1.DTO.ProductsDTO;
import ComputerShop1.Entity.Categories;

@Service
public interface ICategoryService {
	public List<ProductsDTO> GetProductByIDCategory(long id);
	public List<Categories> GetDataCategoriesPaginate(String keyword, int start, int totalPage);
	public List<ProductsDTO> GetDataProductsPaginateByIdCategory(long id, int start, int totalPage);
	public List<Categories> GetDataCategories();
	public List<Categories> SearchCategory(String keyword);
	public int AddCategory(Categories category);
	public int UpdateCategory(Categories category);
	public int DeleteCategory(long id);
}
