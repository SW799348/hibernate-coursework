package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Transaction;
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

public class UserDto implements Serializable {
    private Long userID;
    private String name;
    private String email;
    private String password;

    private List<TransactionDto> transactionList = new ArrayList<>();
    private AdminDto admin;


    public User toEntity() {
        User userEntity = new User();
        userEntity.setUserID(this.userID);
        userEntity.setName(this.name);
        userEntity.setEmail(this.email);

        if (transactionList != null) {
            List<Transaction> transactions = new ArrayList<>();
            for (TransactionDto transactionDto : this.transactionList) {
                transactions.add(transactionDto.toEntity());
            }
            userEntity.setTransactionList(transactions);
        }

        if(admin!=null){
            userEntity.setAdmin(admin.toEntity());
        }

        return userEntity;
    }
}
