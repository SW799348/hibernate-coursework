package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.UserDTO;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface UserService  extends SuperService {

    Long saveUser(UserDTO userDTO);

    UserDTO getUser(long id);

    boolean updateUser(UserDTO userDTO);

    boolean deleteUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

}
