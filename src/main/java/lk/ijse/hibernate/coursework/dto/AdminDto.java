package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.entity.User;

import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdminDto implements Serializable {
    private Long adminId;
    private String username;
    private String password;
    private List<BookDto> bookList;
    private List<UserDto> userList;
    private List<BranchDto> branchList;

    public AdminDto() {
    }

    public AdminDto(Long adminId, String username, String password, List<BookDto> bookList, List<UserDto> userList, List<BranchDto> branchList) {
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

    public List<BookDto> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookDto> bookList) {
        this.bookList = bookList;
    }

    public List<UserDto> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDto> userList) {
        this.userList = userList;
    }

    public List<BranchDto> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<BranchDto> branchList) {
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

    public Admin toEntity(){
        Admin adminEntity = new Admin();
        adminEntity.setAdminId(this.adminId);
        adminEntity.setUsername(this.username);
        adminEntity.setPassword(this.password);

        // You need to convert lists of DTOs to lists of entities before setting them
        List<Book> books = new ArrayList<>();
        for (BookDto bookDto : this.bookList) {
            books.add(bookDto.toEntity());
        }
        adminEntity.setBookList(books);

        List<User> users = new ArrayList<>();
        for (UserDto userDto : this.userList) {
            users.add(userDto.toEntity());
        }
        adminEntity.setUserList(users);

        List<Branch> branches = new ArrayList<>();
        for (BranchDto branchDto : this.branchList) {
            branches.add(branchDto.toEntity());
        }
        adminEntity.setBranchList(branches);

        return adminEntity;
    }
}
