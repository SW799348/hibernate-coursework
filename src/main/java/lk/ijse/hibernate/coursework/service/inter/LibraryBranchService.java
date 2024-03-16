package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.LibraryBranchDTO;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface LibraryBranchService extends SuperService {

    Long saveLibraryBranch(LibraryBranchDTO libraryBranchDTO);

    LibraryBranchDTO getLibraryBranch(long id);

    boolean updateLibraryBranch(LibraryBranchDTO libraryBranchDTO);

    boolean deleteLibraryBranch(LibraryBranchDTO libraryBranchDTO);

    List<LibraryBranchDTO> getAllLibraryBranches();
}
