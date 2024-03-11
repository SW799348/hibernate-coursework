package lk.ijse.hibernate.coursework.entity;

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


}
