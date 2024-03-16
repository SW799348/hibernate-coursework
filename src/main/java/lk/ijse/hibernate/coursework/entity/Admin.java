package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Admin {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;
        private String password;

        private String email;


        @OneToMany(mappedBy = "admin")
        private List<Book> books;

        @OneToMany(mappedBy = "admin")
        private List<LibraryBranch> libraryBranches;

        @OneToMany(mappedBy = "admin")
        private List<User> users;

        public AdminDTO toDTO(){
                AdminDTO adminDTO = new AdminDTO();
                adminDTO.setId(this.id);
                adminDTO.setUsername(this.username);
                adminDTO.setPassword(this.password);
                adminDTO.setEmail(this.email);
//        if (this.books!=null) {
//            List<BookDTO> bookDTOS = new ArrayList<>();
//            for (Book book : this.books) {
//                bookDTOS.add(book.toDTO());
//            }
//            adminDTO.setBooks(bookDTOS);
//        }
//        if (this.libraryBranches!=null) {
//            List<LibraryBranchDTO> libraryBranchDTOS = new ArrayList<>();
//            for (LibraryBranch libraryBranch : this.libraryBranches) {
//                libraryBranchDTOS.add(libraryBranch.toDTO());
//            }
//            adminDTO.setLibraryBranches(libraryBranchDTOS);
//
//        }
//        if (this.users!=null) {
//            List<UserDTO> userDTOS = new ArrayList<>();
//            for (User user : this.users) {
//                userDTOS.add(user.toDTO());
//            }
//            adminDTO.setUsers(userDTOS);
//        }
                return adminDTO;
        }

}
