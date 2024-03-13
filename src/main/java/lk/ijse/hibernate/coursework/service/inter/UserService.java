package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface UserService  extends SuperService {

    Long saveUser(UserDto userDto);
    UserDto getUser(long id);
    boolean updateUser(UserDto userDto);
    boolean deleteUser(UserDto userDto);
    List<UserDto> getAllUsers();


    boolean authenticateUser(String username, String password);
}
