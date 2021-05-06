package ComputerShop1.Service.User;

import org.springframework.stereotype.Service;

import ComputerShop1.DTO.PaginatesDTO;

@Service
public interface IPaginateService {
	public PaginatesDTO GetInfoPaginates(int totalData, int limit, int currentPage);
}
