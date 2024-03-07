package lk.ijse.hibernate.coursework.entity;

import javax.persistence.*;
import java.util.List;

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

        public Admin() {
        }

        public Admin(Long adminId, String username, String password, List<Book> bookList, List<User> userList, List<Branch> branchList) {
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
                return "Admin{" +
                        "adminId=" + adminId +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", bookList=" + bookList +
                        ", userList=" + userList +
                        ", branchList=" + branchList +
                        '}';
        }
}
