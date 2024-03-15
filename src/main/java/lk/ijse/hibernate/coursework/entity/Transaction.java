package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.TransactionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookID")
    private Book book;

    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    private Date DueDate;



    public TransactionDto toDto(){
        TransactionDto transactionDto = new TransactionDto();

        transactionDto.setTransactionID(this.transactionID);
        transactionDto.setBorrowDate(this.borrowDate);
        transactionDto.setReturnDate(this.returnDate);
        transactionDto.setDueDate(this.DueDate);

        if(book!=null){
            transactionDto.setBook(book.toDto());
        }

        if(user!=null){
            transactionDto.setUser(user.toDto());
        }

        return transactionDto;
    }
}
