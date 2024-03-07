package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Book;

import java.io.Serializable;

public class BookDto implements Serializable {

    private Long bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus;
    private int qty;


}
