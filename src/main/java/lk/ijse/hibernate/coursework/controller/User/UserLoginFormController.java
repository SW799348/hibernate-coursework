package lk.ijse.hibernate.coursework.controller.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.coursework.service.impl.UserServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.UserService;

import java.io.IOException;


public class UserLoginFormController {


    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private AnchorPane loginAnchorPane;

    private  UserService userService;


   public void initialize(){
       userService=UserServiceImpl.getInstance();
   }


    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {

        String username=txtUsername.getText();
        String password = txtPassword.getText();

        boolean isAuthenticated = userService.authenticateUser(username, password);

        if (isAuthenticated ) {

            Parent loginAnchorPane = FXMLLoader.load(this.getClass().getResource("/view/User/dashboardUserForm.fxml"));

            Scene scene = new Scene(loginAnchorPane);
            Stage stage = (Stage) this.loginAnchorPane.getScene().getWindow();

            stage.setTitle("User Dashboard");
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

    @FXML
    void SignUpOnAction(MouseEvent event) throws IOException {
        Parent loginAnchorPane = FXMLLoader.load(this.getClass().getResource("/view/User/userSignUpForm.fxml"));

        Scene scene = new Scene(loginAnchorPane);
        Stage stage = (Stage) this.loginAnchorPane.getScene().getWindow();

        stage.setTitle("User Dashboard");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

}
