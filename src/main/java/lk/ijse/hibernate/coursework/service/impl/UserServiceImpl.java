package lk.ijse.hibernate.coursework.service.impl;

import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.repository.impl.UserRepositoryImpl;
import lk.ijse.hibernate.coursework.repository.inter.UserRepository;
import lk.ijse.hibernate.coursework.service.inter.UserService;
import org.hibernate.Session;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserService userService;

    private Session session;

    private final UserRepository userRepository;

    private UserServiceImpl() {
       userRepository= UserRepositoryImpl.getInstance();
    }

    public static UserService getInstance(){
        return null==userService? userService=new UserServiceImpl() : userService;
    }
    @Override
    public Long saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUser(long id) {
        return null;
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        return false;
    }

    @Override
    public boolean deleteUser(UserDto userDto) {
        return false;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }
}
