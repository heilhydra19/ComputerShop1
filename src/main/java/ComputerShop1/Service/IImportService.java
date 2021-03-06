package ComputerShop1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComputerShop1.DTO.ImportDetailsDTO;
import ComputerShop1.DTO.ImportsDTO;
@Service
public interface IImportService {
	@Autowired
	public List<ImportsDTO> GetDataImports();
	public double GetTotalPrice(long id);
	public List<ImportsDTO> GetDataImportsPaginate(String keyword, int start, int totalPage);
	public List<ImportDetailsDTO> GetDataImportDetailsPaginate(long id, int start, int totalPage);
	public List<ImportsDTO> SearchImport(String keyword);
	public int AddImport(ImportsDTO imports);
	public int UpdateImport(ImportsDTO imports);
	public int DeleteImport(long id);
	public List<ImportDetailsDTO> GetDataImportDetailById(long id);
	public int AddImportDetail(ImportDetailsDTO importDetail);
	public int UpdateImportDetail(ImportDetailsDTO importDetail);
	public int DeleteImportDetail(long id_import, long id);
}
