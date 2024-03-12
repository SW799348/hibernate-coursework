package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.TransactionDto;
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



    public UserDto toDto(){
        UserDto userDto = new UserDto();
        userDto.setUserID(this.userID);
        userDto.setName(this.name);
        userDto.setEmail(this.email);
        userDto.setPassword(this.password);
        userDto.setAdmin(this.admin);

        List<TransactionDto> transactionDtos=new ArrayList<>();
        for (Transaction transaction : this.transactionList){
            transactionDtos.add(transaction.toDto());
        }
        userDto.setTransactionList(transactionDtos);

        return userDto;
    }
}
