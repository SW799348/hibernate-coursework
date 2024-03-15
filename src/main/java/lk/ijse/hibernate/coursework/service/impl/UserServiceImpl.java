package lk.ijse.hibernate.coursework.service.impl;

import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.repository.impl.UserRepositoryImpl;
import lk.ijse.hibernate.coursework.repository.inter.UserRepository;
import lk.ijse.hibernate.coursework.service.inter.UserService;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfig;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserService userService;

    private Session session;

    private final UserRepository userRepository;

    private List<UserDto> userDtoList;

    private UserServiceImpl() {
       userRepository= UserRepositoryImpl.getInstance();
        userDtoList=getAllUsers();
    }

    public static UserService getInstance(){
        return null==userService? userService=new UserServiceImpl() : userService;
    }
    @Override
    public boolean saveUser(UserDto userDto) {

        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            Long id = userRepository.save(userDto.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            if (transaction !=null){
                transaction.rollback();
            }
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public UserDto getUser(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            userRepository.setSession(session);
            User user = userRepository.get(id);
            session.close();
            return user.toDto();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateUser(UserDto userDto) {

        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.update(userDto.toEntity());
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
    public boolean deleteUser(UserDto userDto) {

        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            userRepository.setSession(session);
            userRepository.delete(userDto.toEntity()); // We pass it to the repository by converting it to an entity
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
    public List<UserDto> getAllUsers() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        userRepository.setSession(session);
        List<User> allUsers = userRepository.getAll(); // Here we're getting Entity type object result
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : allUsers) {
            userDtos.add(user.toDto()); // We convert the Entity back to a dto type before return to the controller
        }
        return userDtos;

    }

    @Override
    public boolean authenticateUser(String username, String password) {
        for (UserDto userDto : userDtoList) {
            if (userDto.getName().equals(username) && userDto.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
}







}
