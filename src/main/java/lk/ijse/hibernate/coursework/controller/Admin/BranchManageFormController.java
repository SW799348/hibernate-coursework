package lk.ijse.hibernate.coursework.controller.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.dto.BookDTO;
import lk.ijse.hibernate.coursework.dto.LibraryBranchDTO;
import lk.ijse.hibernate.coursework.dto.tm.BookTM;
import lk.ijse.hibernate.coursework.dto.tm.BranchTM;
import lk.ijse.hibernate.coursework.service.impl.AdminServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.LibraryBranchServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.AdminService;
import lk.ijse.hibernate.coursework.service.inter.LibraryBranchService;

import java.util.List;

public class BranchManageFormController {

    @FXML
    private TableColumn<?, ?> colAdminId;

    @FXML
    private TableColumn<?, ?> colBranchId;

    @FXML
    private TableColumn<?, ?> colBranchName;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableView<BranchTM> tblBranch;

    @FXML
    private TextField txtBranchName;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtSearch;

    private LibraryBranchService libraryBranchService;

    private AdminService adminService;

    private long adminID;

    private  LibraryBranchDTO existingBranch;

    public void initialize(){
        libraryBranchService= LibraryBranchServiceImpl.getInstance();
        adminService= AdminServiceImpl.getInstance();
        adminID=AdminLoginFormController.adminId;
        setCellVAlueFactory();
        loadAllBranches();
    }

    private void loadAllBranches() {
        tblBranch.getItems().clear();

        try {
            List<LibraryBranchDTO> allBranches = libraryBranchService.getAllLibraryBranches();
            for (LibraryBranchDTO branchDTO : allBranches) {
                tblBranch.getItems().add(
                        new BranchTM(
                                branchDTO.getId(),
                                branchDTO.getName(),
                                branchDTO.getLocation(),
                                branchDTO.getAdmin() // Set admin ID
                        )
                );
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCellVAlueFactory() {
        colBranchId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colAdminId.setCellValueFactory(new PropertyValueFactory<>("adminId"));


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        boolean isDeleted = libraryBranchService.deleteLibraryBranch(existingBranch);

        if(isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"branch deleted").show();
            txtBranchName.setText("");
            txtLocation.setText("");
            txtSearch.setText("");

        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        LibraryBranchDTO libraryBranchDTO = new LibraryBranchDTO();

        libraryBranchDTO.setName(txtBranchName.getText());
        libraryBranchDTO.setLocation(txtLocation.getText());


        AdminDTO admin = adminService.getAdmin(adminID);
        libraryBranchDTO.setAdmin(admin);

        Long savedLibraryBranch = libraryBranchService.saveLibraryBranch(libraryBranchDTO);
        if(savedLibraryBranch!=null){
            new Alert(Alert.AlertType.CONFIRMATION,"branch saved!").show();
            txtBranchName.setText("");
            txtLocation.setText("");




        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        long branchId = Long.parseLong(txtSearch.getText());

         existingBranch = libraryBranchService.getLibraryBranch(branchId);

         txtBranchName.setText(existingBranch.getName());
         txtLocation.setText(existingBranch.getLocation());
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        LibraryBranchDTO libraryBranchDTO = new LibraryBranchDTO();
        libraryBranchDTO.setId(existingBranch.getId());
        libraryBranchDTO.setName(txtBranchName.getText());
        libraryBranchDTO.setLocation(txtLocation.getText());

        boolean isUpdated = libraryBranchService.updateLibraryBranch(libraryBranchDTO);
        if(isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"branch updated successfully!").show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

}
