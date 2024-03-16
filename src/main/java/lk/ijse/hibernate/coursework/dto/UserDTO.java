package lk.ijse.hibernate.coursework.dto;

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

public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;

    private AdminDTO admin;
    private List<TransactionDTO> transactions;

    public User toEntity(){
        User user = new User();
        user.setId(this.id);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        if (this.admin!=null) {
            user.setAdmin(this.admin.toEntity());
        }
        if (this.transactions!=null) {
            List<Transaction> transactionList = new ArrayList<>();
            for (TransactionDTO transactionDto : transactions) {
                transactionList.add(transactionDto.toEntity());
            }
            user.setTransactions(transactionList);
        }
        return user;
    }
}
