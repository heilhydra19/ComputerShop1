package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.CategoriesDAO;
import ComputerShop1.DAO.ProductsDAO;
import ComputerShop1.DTO.ProductsDTO;
import ComputerShop1.Entity.Categories;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ProductsDAO productsDAO;
	@Autowired
	private CategoriesDAO categoriesDAO;

	public List<ProductsDTO> GetProductByIDCategory(long id) {
		return productsDAO.GetProductByIDCategory(id);
	}

	public List<ProductsDTO> GetDataProductsPaginateByIdCategory(long id, int start, int totalPage) {
		return productsDAO.GetDataProductsPaginateByIdCategory(id, start, totalPage);
	}
	
	public List<Categories> GetDataCategories() {
		return categoriesDAO.GetDataCategories();
	}

	public int AddCategory(Categories category) {
		return categoriesDAO.AddCategory(category);
	}

	public int UpdateCategory(Categories category) {
		return categoriesDAO.UpdateCategory(category);
	}

	public int DeleteCategory(long id) {
		return categoriesDAO.DeleteCategory(id);
	}

	public List<Categories> SearchCategory(String keyword) {
		return categoriesDAO.SearchCategory(keyword);
	}

	public List<Categories> GetDataCategoriesPaginate(String keyword, int start, int totalPage) {
		return categoriesDAO.GetDataCategoriesPaginate(keyword, start, totalPage);
	}
}
