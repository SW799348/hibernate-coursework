package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Transaction;
import lk.ijse.hibernate.coursework.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {
    private Long userID;
    private String name;
    private String email;
    private String password;

    private List<TransactionDto> transactionList;
    private Admin admin;

    public UserDto() {
    }

    public UserDto(Long userID, String name, String email, String password, List<TransactionDto> transactionList, Admin admin) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.transactionList = transactionList;
        this.admin = admin;
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

    public List<TransactionDto> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<TransactionDto> transactionList) {
        this.transactionList = transactionList;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userID=" + userID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", transactionList=" + transactionList +
                ", admin=" + admin +
                '}';
    }

public User toEntity(){
    User userEntity = new User();
    userEntity.setUserID(this.userID);
    userEntity.setName(this.name);
    userEntity.setEmail(this.email);
    userEntity.setTransactionList(this.transactionList);

    List<Transaction> transactions=new ArrayList<>();
    for (TransactionDto transactionDto: this.transactionList){

    }

}
}
