package lk.ijse.hibernate.coursework.controller.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.dto.LibraryBranchDTO;
import lk.ijse.hibernate.coursework.dto.UserDTO;
import lk.ijse.hibernate.coursework.dto.tm.BranchTM;
import lk.ijse.hibernate.coursework.dto.tm.UserTM;
import lk.ijse.hibernate.coursework.service.impl.AdminServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.UserServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.AdminService;
import lk.ijse.hibernate.coursework.service.inter.UserService;

import java.util.List;

public class UserManageFormController {

    @FXML
    private TableColumn<?, ?> colAdminId;

    @FXML
    private TableColumn<?, ?> colMail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private TextField txtAdminID;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtUserId;

    @FXML
    private TableView<UserTM> tblUser;

    private static UserService userService;

    private static AdminService adminService;

    private long adminID;

    private static UserDTO existingUser;

    public void initialize(){
        userService= UserServiceImpl.getInstance();
        adminService= AdminServiceImpl.getInstance();
        adminID=AdminLoginFormController.adminId;
        setCellVAlueFactory();
        loadAllUsers();
    }

    private void loadAllUsers() {
        tblUser.getItems().clear();

        try {
            List<UserDTO> allUsers = userService.getAllUsers();
            for (UserDTO userDTO : allUsers) {
                tblUser.getItems().add(
                        new UserTM(
                                userDTO.getId(),
                                userDTO.getUsername(),
                                userDTO.getEmail()
                        )
                );
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }



    private void setCellVAlueFactory() {
        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("username"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("email"));


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        boolean isDeleted = userService.deleteUser(existingUser);

        if(isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"book deleted").show();
            txtName.setText("");
            txtMail.setText("");
            txtSearch.setText("");
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }



    @FXML
    void btnSaveOnAction(ActionEvent event) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(txtName.getText());
        userDTO.setEmail(txtMail.getText());

        AdminDTO admin = adminService.getAdmin(adminID);
        userDTO.setAdmin(admin);

        Long saveUser = userService.saveUser(userDTO);
        if(saveUser!=null){
            new Alert(Alert.AlertType.CONFIRMATION,"user saved!").show();
            txtName.setText("");
            txtMail.setText("");
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        Long userId = Long.valueOf(txtSearch.getText());

        existingUser = userService.getUser(userId);
        txtName.setText(existingUser.getUsername());
        txtMail.setText(existingUser.getEmail());
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(existingUser.getId());
        userDTO.setUsername(txtName.getText());
        userDTO.setEmail(txtMail.getText());

        boolean isUpdated = userService.updateUser(userDTO);

        if(isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"user updated successfully").show();
        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }
    }

}
