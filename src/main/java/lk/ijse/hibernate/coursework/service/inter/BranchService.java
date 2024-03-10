package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.BranchDto;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface BranchService  extends SuperService {

    Long saveBranch(BranchDto branchDto);
    BranchDto getBranch(long id);
    boolean updateBranch(BranchDto branchDto);
    boolean deleteBranch(BranchDto branchDto);
    List<BranchDto> getAllBranches();
}
