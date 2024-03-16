package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.LibraryBranch;
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

public class AdminDTO implements Serializable {
    private Long id;
    private String username;
    private String password;

    private String email;
    private List<BookDTO> books;
    private List<LibraryBranchDTO> libraryBranches;
    private List<UserDTO> users;

    public Admin toEntity() {
        Admin admin = new Admin();
        admin.setId(this.getId());
        admin.setUsername(this.getUsername());
        admin.setPassword(this.getPassword());
        admin.setEmail(this.getEmail());

//        dto lists convert to entity lists
        if (this.books !=null) {
            List<Book> bookList = new ArrayList<>();
            for (BookDTO bookDTO : books) {
                bookList.add(bookDTO.toEntity());
            }
            admin.setBooks(bookList);
        }

        if (this.libraryBranches !=null) {
            List<LibraryBranch> libraryBranchList = new ArrayList<>();

            for (LibraryBranchDTO libraryBranchDTO : this.libraryBranches) {
                libraryBranchList.add(libraryBranchDTO.toEntity());
            }

            admin.setLibraryBranches(libraryBranchList);
        }
        if (this.users!=null) {
            List<User> userList = new ArrayList<>();

            for (UserDTO userDto : users) {
                userList.add(userDto.toEntity());
            }

            admin.setUsers(userList);
        }
        return admin;
    }

}
