package lk.ijse.hibernate.coursework.controller.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.coursework.dto.BookDto;
import lk.ijse.hibernate.coursework.service.impl.BookServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.BookService;

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
    private TextField txtSearch;

    private BookService bookService;

    public void initialize(){
        bookService= BookServiceImpl.getInstance();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {



    }

}
