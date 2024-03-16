package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface AdminService  extends SuperService {
    Long saveAdmin(AdminDTO adminDTO);

    AdminDTO getAdmin(long id);

    boolean updateAdmin(AdminDTO adminDTO);

    boolean deleteAdmin(AdminDTO adminDTO);

    List<AdminDTO> getAllAdmins();


}
