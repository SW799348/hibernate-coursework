package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;

import java.io.Serializable;

public class AdminDto implements Serializable {
    private Long adminId;
    private String username;
    private String password;

    public AdminDto() {
    }

    public AdminDto(Long adminId, String username, String password) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Use as a custom converter to easily convert DTO to an Entity type (Code Re-usability)
    public Admin toEntity(){
        Admin adminDto = new Admin();
        adminDto.setAdminId(this.adminId);
        adminDto.setUsername(this.username);
        adminDto.setPassword(this.password);
        return adminDto;
    }
}
