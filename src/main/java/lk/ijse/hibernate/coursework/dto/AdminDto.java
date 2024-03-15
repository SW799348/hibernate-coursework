package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminDto implements Serializable {
    private Long adminId;
    private String username;
    private String password;
    private List<BookDto> bookList;
    private List<UserDto> userList;
    private List<BranchDto> branchList;


    public Admin toEntity() {
        Admin adminEntity = new Admin();
        adminEntity.setAdminId(this.adminId);
        adminEntity.setUsername(this.username);
        adminEntity.setPassword(this.password);


        if (this.bookList != null) {
            List<Book> books = new ArrayList<>();
            for (BookDto bookDto : bookList) {
                books.add(bookDto.toEntity());
            }
            adminEntity.setBookList(books);
        }


        if (userList != null) {
            List<User> users = new ArrayList<>();
            for (UserDto userDto : this.userList) {
                users.add(userDto.toEntity());
            }
            adminEntity.setUserList(users);
        }

        if (branchList != null) {
            List<Branch> branches = new ArrayList<>();
            for (BranchDto branchDto : this.branchList) {
                branches.add(branchDto.toEntity());
            }
            adminEntity.setBranchList(branches);
        }


        return adminEntity;
    }
}
