package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.TransactionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date returnDate;
    private Date borrowDate;
    private Date dueDate;
    private int qty;



    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public TransactionDTO toDTO(){
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(this.id);
        transactionDTO.setReturnDate(this.returnDate);
        transactionDTO.setBorrowDate(this.borrowDate);
        transactionDTO.setDueDate(this.dueDate);
        transactionDTO.setQty(this.qty);
        if (this.user!=null) {
            transactionDTO.setUser(this.user.toDTO());
        }
        if (this.book!=null) {
            transactionDTO.setBook(this.book.toDTO());
        }
        return transactionDTO;
    }
}
