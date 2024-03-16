package lk.ijse.hibernate.coursework.controller.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.dto.BookDTO;
import lk.ijse.hibernate.coursework.dto.LibraryBranchDTO;
import lk.ijse.hibernate.coursework.dto.tm.BookTM;
import lk.ijse.hibernate.coursework.service.impl.AdminServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.BookServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.LibraryBranchServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.AdminService;
import lk.ijse.hibernate.coursework.service.inter.BookService;
import lk.ijse.hibernate.coursework.service.inter.LibraryBranchService;

import java.util.List;

public class BookManageFormController {

    @FXML
    private ComboBox<String> cmbGenre;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookID;

    @FXML
    private TableColumn<?, ?> colBranch;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colTittle;

    @FXML
    private TableView<?> tblBookManage;

    @FXML
    private TextField txtAuthor;


    @FXML
    private TextField txtBranch;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtTittle;

    private LibraryBranchService libraryBranchService;
    private AdminService adminService;

    private BookService bookService;

    private long adminID;

    private BookDTO existingBook;


    public void initialize() {
        setValueToComboBox();
        libraryBranchService= LibraryBranchServiceImpl.getInstance();
        adminService= AdminServiceImpl.getInstance();
        bookService= BookServiceImpl.getInstance();
        adminID=AdminLoginFormController.adminId;
        setCellVAlueFactory();
        loadAllBooks();
    }

    private void loadAllBooks() {
//        tblBookManage.getItems().clear();
//
//        try {
//            List<BookDTO> allBooks = bookService.getAllBooks();
//            for (BookDTO bookDto: allBooks) {
//                LibraryBranchDTO libraryBranch = bookDto.getLibraryBranch();
//                tblBookManage.getItems().add(
//                      new BookTM(
//                              bookDto.getId(),
//                              bookDto.getTitle(),
//                              bookDto.getAuthor(),
//                              bookDto.getGener(),
//                              bookDto.getQty(),
//                              bookDto.getAdmin(),
//
//
//
//
//                      )
//              );
//            }
//        }
    }

    private void setCellVAlueFactory() {
        colBookID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTittle.setCellValueFactory(new PropertyValueFactory<>("tittle"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("gener"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colBranch.setCellValueFactory(new PropertyValueFactory<>("branch"));

    }

    public void setValueToComboBox() {
        cmbGenre.getItems().add("Comedy");
        cmbGenre.getItems().add("Novel");
        cmbGenre.getItems().add("Short Story");
        cmbGenre.getItems().add("Mystry");
        cmbGenre.getItems().add("Kids Books");





    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        boolean isDeleted = bookService.deleteBook(existingBook);
        if(isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"book deleted").show();
            txtTittle.setText("");
            txtAuthor.setText("");
            cmbGenre.setValue("");
            txtBranch.setText("");
            txtQty.setText("");
            txtSearch.setText("");
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setTitle(txtTittle.getText());
        bookDTO.setGener(cmbGenre.getValue());
        bookDTO.setAuthor(txtAuthor.getText());
        bookDTO.setQty(Integer.parseInt(txtQty.getText()));



        List<LibraryBranchDTO> allLibraryBranches = libraryBranchService.getAllLibraryBranches();

        for (LibraryBranchDTO libraryBranchDTO : allLibraryBranches) {
            if (libraryBranchDTO.getLocation().equals(txtBranch.getText())) {
                bookDTO.setLibraryBranch(libraryBranchDTO);
            }

        }
        AdminDTO admin = adminService.getAdmin(adminID);
        bookDTO.setAdmin(admin);

        Long saveBook = bookService.saveBook(bookDTO);
        if(saveBook!=null){
            new Alert(Alert.AlertType.CONFIRMATION,"book saved!").show();
            txtTittle.setText("");
            txtAuthor.setText("");
            cmbGenre.setValue("");
            txtBranch.setText("");
            txtQty.setText("");



        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }


    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        Long bookId = Long.valueOf(txtSearch.getText());



        if(bookId.equals(existingBook)){
            existingBook = bookService.getBook(bookId);
            txtTittle.setText(existingBook.getTitle());
            txtAuthor.setText(existingBook.getAuthor());
            cmbGenre.setValue(existingBook.getGener());
            txtQty.setText(String.valueOf(existingBook.getQty()));
        }else{
            new Alert(Alert.AlertType.ERROR,"book can not found!").show();
        }




        // Fetch the branch name from the existingBook's libraryBranch object and set it to the text field
        if (existingBook.getLibraryBranch() != null) {
            txtBranch.setText(existingBook.getLibraryBranch().getLocation());
        } else {
            txtBranch.setText(""); // Handle the case where the branch is null
        }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(existingBook.getId());
        bookDTO.setTitle(txtTittle.getText());
        bookDTO.setAuthor(txtAuthor.getText());
        bookDTO.setGener(cmbGenre.getValue());
        bookDTO.setQty(Integer.parseInt(txtQty.getText()));
       // bookDTO.setLibraryBranch(txtBranch.getText());

        boolean isUpdated = bookService.updateBook(bookDTO);
        if(isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"book updated successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }


    }

    @FXML
    void cmbGenreOnAction(ActionEvent event) {
        String value = cmbGenre.getValue();
    }

}
