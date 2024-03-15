package lk.ijse.hibernate.coursework.service.impl;

import lk.ijse.hibernate.coursework.dto.AdminDto;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.repository.impl.AdminRepositoryImpl;
import lk.ijse.hibernate.coursework.repository.inter.AdminRepository;
import lk.ijse.hibernate.coursework.service.inter.AdminService;
import lk.ijse.hibernate.coursework.service.inter.UserService;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private static AdminService adminService;

    private Session session;

    private final AdminRepository adminRepository;

    private List<AdminDto> adminDtoList;

    private AdminServiceImpl(){
    adminRepository=AdminRepositoryImpl.getInstance();
    adminDtoList=getAllAdmins();

    }

    public static AdminService getInstance(){
        return null==adminService?adminService=new AdminServiceImpl() :adminService;
    }
    @Override
    public Long saveAdmin(AdminDto adminDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            adminRepository.setSession(session);
            Long id = adminRepository.save(adminDto.toEntity());
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
    public AdminDto getAdmin(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            adminRepository.setSession(session);
            Admin admin = adminRepository.get(id);
            session.close();
            return admin.toDto();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateAdmin(AdminDto adminDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            adminRepository.setSession(session);
            adminRepository.update(adminDto.toEntity());
            transaction.commit();
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
    public boolean deleteAdmin(AdminDto adminDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            adminRepository.setSession(session);
            adminRepository.delete(adminDto.toEntity()); // We pass it to the repository by converting it to an entity
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
    public List<AdminDto> getAllAdmins() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        adminRepository.setSession(session);
        List<Admin> allAdmins = adminRepository.getAll(); // Here we're getting Entity type object result
        List<AdminDto> adminDtoArrayList = new ArrayList<>();
        for (Admin admin : allAdmins) {
            adminDtoArrayList.add(admin.toDto()); // We convert the Entity back to a dto type before return to the controller
        }
        return adminDtoArrayList;
    }

    @Override
    public boolean authenticateAdmin(String username, String password) {
        for (AdminDto adminDto : adminDtoList){
            if(adminDto.getUsername().equals(username) && adminDto.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
