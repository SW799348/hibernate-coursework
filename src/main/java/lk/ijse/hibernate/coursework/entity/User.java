package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    @ManyToOne
    private Admin admin;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;



    public UserDTO toDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(this.id);
        userDTO.setUsername(this.username);
        userDTO.setPassword(this.password);
        userDTO.setEmail(this.email);
//        if (this.admin!=null) {
//            userDTO.setAdmin(this.admin.toDTO());
//        }
//        if (this.transactions!=null) {
//            List<TransactionDTO> transactionList = new ArrayList<>();
//            for (Transaction transaction : transactions) {
//                transactionList.add(transaction.toDTO());
//            }
//            userDTO.setTransactions(transactionList);
//        }
        return userDTO;
    }
}
