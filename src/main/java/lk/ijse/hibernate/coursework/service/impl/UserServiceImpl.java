package lk.ijse.hibernate.coursework.service.impl;

import lk.ijse.hibernate.coursework.dto.UserDTO;
import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.repository.impl.UserRepositoryImpl;
import lk.ijse.hibernate.coursework.repository.inter.UserRepository;
import lk.ijse.hibernate.coursework.service.inter.UserService;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private Session session;
    private static UserService userService;

    private final UserRepository userRepository;
    private List<UserDTO>userDTOList;

    private UserServiceImpl(){
        userRepository=UserRepositoryImpl.getInstance();
        userDTOList=getAllUsers();
    }
    public static UserService getInstance(){
        return (null==userService)
                ?userService=new UserServiceImpl()
                :userService;
    }
    @Override
    public Long saveUser(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            Long id = userRepository.save(userDTO.toEntity());
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
    public UserDTO getUser(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            userRepository.setSession(session);
            User user = userRepository.get(id);
            session.close();
            return user.toDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.update(userDTO.toEntity());
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
    public boolean deleteUser(UserDTO userDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.delete(userDTO.toEntity());
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
    public List<UserDTO> getAllUsers() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        userRepository.setSession(session);
        List<User> allUsers= userRepository.getAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : allUsers) {
            userDTOList.add(user.toDTO());
        }
        return userDTOList;
    }



}
