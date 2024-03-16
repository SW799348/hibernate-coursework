package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private Long id;

    private String title;
    private String author;
    private String gener;
    private int qty;
    private AdminDTO admin;
    private LibraryBranchDTO libraryBranch;
    private List<TransactionDTO> transactions;

    public Book toEntity() {
        Book book = new Book();
        book.setId(this.id);
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setGener(this.gener);
        book.setQty(this.qty);
        if (this.admin!=null) {
            book.setAdmin(this.admin.toEntity());
        }
        if (this.libraryBranch!=null) {
            book.setLibraryBranch(this.libraryBranch.toEntity());
        }
        if (this.transactions!=null) {
            List<Transaction> transactionList = new ArrayList<>();
            for (TransactionDTO transactionDto : this.transactions) {
                transactionList.add(transactionDto.toEntity());
            }
            book.setTransactions(transactionList);
        }
        return book;


    }
}
