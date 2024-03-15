package lk.ijse.hibernate.coursework.controller.User;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private TableView<?> tblMyBooks;



}
