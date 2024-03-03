package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.User;

import java.io.Serializable;

public class UserDto implements Serializable {
    private Long userID;
    private String name;
    private String email;
    private String password;

    public UserDto() {
    }

    public UserDto(Long userID, String name, String email, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public User toEntity(){
        User userDto = new User();
        userDto.setUserID(this.userID);
        userDto.setName(this.name);
        userDto.setEmail(this.email);
        userDto.setPassword(this.password);
        return userDto;
    }
}
