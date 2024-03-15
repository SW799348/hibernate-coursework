package lk.ijse.hibernate.coursework.controller.Admin;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.hibernate.coursework.dto.BookDto;
import lk.ijse.hibernate.coursework.dto.BranchDto;
import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.service.impl.BookServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.BranchServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.BookService;
import lk.ijse.hibernate.coursework.service.inter.BranchService;

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
    private TextField txtAdminId;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtAvailability;

    @FXML
    private TextField txtBookID;

    @FXML
    private TextField txtBranch;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtTittle;

    private static BookService bookService;

    private static BranchService branchService;

    public void initialize(){
        bookService= BookServiceImpl.getInstance();
        branchService= BranchServiceImpl.getInstance();

    }
    private void setGenreToComboBox(){
        cmbGenre.getItems().add("Comedy");
        cmbGenre.getItems().add("Mystry");
        cmbGenre.getItems().add("Historical");
        cmbGenre.getItems().add("Novel");
        cmbGenre.getItems().add("Short Story");

    }

    @FXML
    void cmbGenreOnAction(ActionEvent event) {

        String genre=cmbGenre.getValue();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Long bookID = Long.valueOf(txtBookID.getText());
        var tittle = txtTittle.getText();
        var author = txtAuthor.getText();
        int qty = Integer.parseInt(txtQty.getText());
        String genre = String.valueOf(cmbGenre.getItems());
        boolean availability = Boolean.parseBoolean(txtAvailability.getText());
        String branch = txtBranch.getText();

        BranchDto branchDto1=new BranchDto();

        List<BranchDto> allBranches = branchService.getAllBranches();
        for(BranchDto branchDto : allBranches){
            if(branchDto.getBranchName().equals(branch)){
                branchDto1=branchDto;
            }
        }



    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
