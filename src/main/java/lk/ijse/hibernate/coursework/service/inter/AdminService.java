package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.AdminDto;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface AdminService  extends SuperService {
    Long saveAdmin(AdminDto adminDto);
    AdminDto getAdmin(long id);
    boolean updateAdmin(AdminDto adminDto);
    boolean deleteAdmin(AdminDto adminDto);
    List<AdminDto> getAllAdmins();

    boolean authenticateAdmin(String username, String password);
}
