package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DAO.ImportDetailsDAO;
import ComputerShop1.DAO.ImportsDAO;
import ComputerShop1.DTO.ImportDetailsDTO;
import ComputerShop1.DTO.ImportsDTO;

@Service
public class ImportServiceImpl implements IImportService{
	@Autowired
	private ImportsDAO importsDAO;
	@Autowired
	private ImportDetailsDAO importDetailsDAO;
	
	public List<ImportsDTO> GetDataImports() {
		return importsDAO.GetDataImports();
	}

	public int AddImport(ImportsDTO imports) {
		return importsDAO.AddImport(imports);
	}

	public int UpdateImport(ImportsDTO imports) {
		return importsDAO.UpdateImport(imports);
	}

	public int DeleteImport(long id) {
		return importsDAO.DeleteImport(id);
	}

	public double GetTotalPrice(long id) {
		return importDetailsDAO.GetTotalPrice(id);
	}

	public List<ImportDetailsDTO> GetDataImportDetailById(long id) {
		return importDetailsDAO.GetDataImportDetailById(id);
	}

	public int AddImportDetail(ImportDetailsDTO importDetail) {
		return importDetailsDAO.AddImportDetail(importDetail);
	}

	public int UpdateImportDetail(ImportDetailsDTO importDetail) {
		return importDetailsDAO.UpdateImportDetail(importDetail);
	}

	public int DeleteImportDetail(long id_import, long id) {
		return importDetailsDAO.DeleteImportDetail(id_import, id);
	}
	
}
