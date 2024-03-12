package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.BookDto;
import lk.ijse.hibernate.coursework.dto.TransactionDto;
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
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID;

    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus;

    private int qty;


    @ManyToOne
    private Admin admin;

    @ManyToOne
    private Branch branch;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactions;


    public BookDto toDto(){
        BookDto bookDto = new BookDto();
        bookDto.setBookID(this.bookID);
        bookDto.setTitle(this.title);
        bookDto.setAuthor(this.author);
        bookDto.setGenre(this.genre);
        bookDto.setAvailabilityStatus(this.availabilityStatus);
        bookDto.setQty(this.qty);
        bookDto.setAdmin(this.admin);
        bookDto.setBranch(this.branch);

        List<TransactionDto> transactionDtos=new ArrayList<>();
        for(Transaction transaction : this.transactions){
            transactionDtos.add(transaction.toDto());
        }
        bookDto.setTransactionList(transactionDtos);

        return bookDto;
    }
}
