package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.entity.User;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

public class AdminDto implements Serializable {
    private Long adminId;
    private String username;
    private String password;
    private List<Book> bookList;
    private List<User> userList;
    private List<Branch> branchList;

    public AdminDto() {
    }

    public AdminDto(Long adminId, String username, String password, List<Book> bookList, List<User> userList, List<Branch> branchList) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.bookList = bookList;
        this.userList = userList;
        this.branchList = branchList;
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bookList=" + bookList +
                ", userList=" + userList +
                ", branchList=" + branchList +
                '}';
    }
}
