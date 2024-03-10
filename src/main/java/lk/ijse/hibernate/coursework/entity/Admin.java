package lk.ijse.hibernate.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

}
