package lk.ijse.hibernate.coursework.service.impl;

import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.repository.impl.AdminRepositoryImpl;
import lk.ijse.hibernate.coursework.repository.inter.AdminRepository;
import lk.ijse.hibernate.coursework.service.inter.AdminService;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private Session session;
    private static AdminService adminService;

    private final AdminRepository adminRepository;

    private List<AdminDTO>adminDTOList;

    private AdminServiceImpl(){
        adminRepository=AdminRepositoryImpl.getInstance();
        adminDTOList=getAllAdmins();
    }
    public static AdminService getInstance(){
        return null==adminService
                ?adminService=new AdminServiceImpl()
                :adminService;
    }

    @Override
    public Long saveAdmin(AdminDTO adminDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            adminRepository.setSession(session);
            Long id = adminRepository.save(adminDTO.toEntity());
            transaction.commit();
            session.close();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1L;
        }
    }

    @Override
    public AdminDTO getAdmin(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            adminRepository.setSession(session);
            Admin admin = adminRepository.get(id);
            session.close();
            return admin.toDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            adminRepository.setSession(session);
            adminRepository.update(adminDTO.toEntity());
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAdmin(AdminDTO adminDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            adminRepository.setSession(session);
            adminRepository.delete(adminDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        adminRepository.setSession(session);
        List<Admin> allAdmins= adminRepository.getAll();
        List<AdminDTO> adminDTOList = new ArrayList<>();
        for (Admin admin : allAdmins) {
            adminDTOList.add(admin.toDTO());
        }
        return adminDTOList;
    }

}
