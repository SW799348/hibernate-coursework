package lk.ijse.hibernate.coursework.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String name;
    private String email;
    private String password;

    @ManyToOne
    private Admin admin;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactionList;


    public User() {
    }

    public User(Long userID, String name, String email, String password, Admin admin, List<Transaction> transactionList) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.transactionList = transactionList;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", transactionList=" + transactionList +
                '}';
    }
}
