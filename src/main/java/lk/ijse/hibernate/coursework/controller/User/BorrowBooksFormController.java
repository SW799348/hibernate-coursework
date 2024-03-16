package lk.ijse.hibernate.coursework.controller.User;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.hibernate.coursework.dto.TransactionDTO;
import lk.ijse.hibernate.coursework.service.impl.BookServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.TransactionServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.BookService;
import lk.ijse.hibernate.coursework.service.inter.TransactionService;

import java.util.Optional;

public class BorrowBooksFormController {

    @FXML
    private TableColumn<?, ?> colTransactionId;

    @FXML
    private TableColumn<?, ?> colBorrowDate;

    @FXML
    private TableColumn<?, ?> colBranch;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colTittle;

    @FXML
    private TableColumn<?, ?> colUsername;

    @FXML
    private TableView<TransactionDTO> tblMyBooks;

    private TransactionService transactionService;

    private BookService bookService;

    public void initialize(){
        transactionService= TransactionServiceImpl.getInstance();
        bookService= BookServiceImpl.getInstance();
    }





}
