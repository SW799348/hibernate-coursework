package lk.ijse.hibernate.coursework.controller.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.coursework.dto.BookDTO;
import lk.ijse.hibernate.coursework.service.impl.BookServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.LibraryBranchServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.BookService;
import lk.ijse.hibernate.coursework.service.inter.LibraryBranchService;

public class SearchBooksFormController {

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colBranch;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTittle;

    @FXML
    private TableView<?> tblSearchBooks;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBranch;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtTittle;

    private BookService bookService;

    private LibraryBranchService branchService;

    private BookDTO existingBook;

    public void initialize(){
        bookService= BookServiceImpl.getInstance();
        branchService= LibraryBranchServiceImpl.getInstance();
    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        Long bookId = Long.valueOf(txtSearch.getText());

        existingBook = bookService.getBook(bookId);
        txtTittle.setText(existingBook.getTitle());
        txtAuthor.setText(existingBook.getAuthor());
        txtGenre.setText(existingBook.getGener());
        txtQty.setText(String.valueOf(existingBook.getQty()));

        // Fetch the branch name from the existingBook's libraryBranch object and set it to the text field
        if (existingBook.getLibraryBranch() != null) {
            txtBranch.setText(existingBook.getLibraryBranch().getLocation());
        } else {
            txtBranch.setText(""); // Handle the case where the branch is null
        }
    }

}
