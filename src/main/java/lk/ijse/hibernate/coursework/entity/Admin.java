package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.AdminDto;
import lk.ijse.hibernate.coursework.dto.BookDto;
import lk.ijse.hibernate.coursework.dto.BranchDto;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "admin")
public class Admin {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long adminId;
        private String username;
        private String password;

        @OneToMany(mappedBy = "admin")
        private List<Book> bookList;

        @OneToMany(mappedBy = "admin")
        private List<User> userList;

        @OneToMany(mappedBy = "admin")
        private List<Branch> branchList;

        public AdminDto toDto(){

                AdminDto adminDto = new AdminDto();
                adminDto.setAdminId(this.adminId);
                adminDto.setUsername(this.username);
                adminDto.setPassword(this.password);


//                List<BookDto> bookDtoList=new ArrayList<>();
//                for (Book book:this.bookList){
//                        bookDtoList.add(book.toDto());
//                }
//                adminDto.setBookList(bookDtoList);
//
//                List<UserDto> userDtoList=new ArrayList<>();
//                for (User user : this.userList){
//                        userDtoList.add(user.toDto());
//                }
//                adminDto.setUserList(userDtoList);
//
//                List<BranchDto> branchDtoList=new ArrayList<>();
//                for (Branch branch :this.branchList){
//                        branchDtoList.add(branch.toDto());
//                }
//                adminDto.setBranchList(branchDtoList);

                return adminDto;
        }

}
