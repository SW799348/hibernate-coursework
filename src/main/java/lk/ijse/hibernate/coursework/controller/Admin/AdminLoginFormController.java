package lk.ijse.hibernate.coursework.controller.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.navigation.Navigation;
import lk.ijse.hibernate.coursework.navigation.Routes;
import lk.ijse.hibernate.coursework.service.impl.AdminServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.UserServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.AdminService;
import lk.ijse.hibernate.coursework.service.inter.UserService;

import java.io.IOException;
import java.util.List;

public class AdminLoginFormController {

    @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    private AdminService adminService;

    public static Long adminId;


    public void initialize() {

        adminService = AdminServiceImpl.getInstance();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        List<AdminDTO> allAdmins = adminService.getAllAdmins();
        for (AdminDTO adminDto : allAdmins) {
            if (adminDto.getUsername().equals(txtUsername.getText()) && adminDto.getPassword().equals(txtPassword.getText())) {
                adminId = adminDto.getId();
                Navigation.navigate(Routes.HOMEADMIN, loginAnchorPane);
            } else {
                new Alert(Alert.AlertType.ERROR, "Admin not found").show();
            }

        }
    }

}

