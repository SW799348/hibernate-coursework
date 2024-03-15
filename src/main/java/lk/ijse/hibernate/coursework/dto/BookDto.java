package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {

    private Long bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus;
    private int qty;
    private AdminDto adminDto;
    private List<TransactionDto> transactionList;
    private BranchDto branchDto;


    public Book toEntity() {

        Book bookEntity = new Book();

        bookEntity.setBookID(this.bookID);
        bookEntity.setTitle(this.title);
        bookEntity.setAuthor(this.author);
        bookEntity.setGenre(this.genre);
        bookEntity.setAvailabilityStatus(this.availabilityStatus);
        bookEntity.setQty(this.qty);

        if (adminDto != null) {
            bookEntity.setAdmin(adminDto.toEntity());
        }

        if (branchDto != null) {
            bookEntity.setBranch(branchDto.toEntity());
        }

        if (transactionList != null) {
            List<Transaction> transactions = new ArrayList<>();
            for (TransactionDto transactionDto : this.transactionList) {
                transactions.add(transactionDto.toEntity());
            }
            bookEntity.setTransactions(transactions);
        }

        return bookEntity;

    }
}
