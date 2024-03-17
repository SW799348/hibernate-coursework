package lk.ijse.hibernate.coursework.controller.User;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.coursework.dto.BookDTO;
import lk.ijse.hibernate.coursework.service.impl.BookServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.LibraryBranchServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.BookService;
import lk.ijse.hibernate.coursework.service.inter.LibraryBranchService;

import java.util.Optional;

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


    @FXML
    private JFXButton btnBorrow;

    private LibraryBranchService branchService;

    private BookDTO existingBook;

    public void initialize(){
        bookService= BookServiceImpl.getInstance();
        branchService= LibraryBranchServiceImpl.getInstance();
        setCellValueFactory();
        loadAllBooks();
    }

    private void loadAllBooks() {
    }

    private void setCellValueFactory() {
        colBookID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTittle.setCellValueFactory(new PropertyValueFactory<>("tittle"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("gener"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("branch"));
    }

    @FXML
    void btnBorrowOnAction(ActionEvent event) {

        if(txtTittle.getText()!= null){
            ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure want to borrow this Book?", ok, no).showAndWait();
            if (result.orElse(no) == ok) {

            }
        }


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
