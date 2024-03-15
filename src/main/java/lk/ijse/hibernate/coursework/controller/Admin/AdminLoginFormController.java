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
import lk.ijse.hibernate.coursework.service.impl.AdminServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.UserServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.AdminService;
import lk.ijse.hibernate.coursework.service.inter.UserService;

import java.io.IOException;

public class AdminLoginFormController {

    @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    private AdminService adminService;


    public void initialize(){
     adminService=AdminServiceImpl.getInstance();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        String username=txtUsername.getText();
        String password = txtPassword.getText();

        boolean isAuthenticated = adminService.authenticateAdmin(username, password);

        if (isAuthenticated ) {

            Parent loginAnchorPane = FXMLLoader.load(this.getClass().getResource("/view/UserForm.fxml"));

            Scene scene = new Scene(loginAnchorPane);
            Stage stage = (Stage) this.loginAnchorPane.getScene().getWindow();

            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.centerOnScreen();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }

    }

}
