package lk.ijse.hibernate.coursework.controller.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.service.impl.UserServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.UserService;

import java.io.IOException;

public class UserSignUpFormController {

    private UserService userService;

    public void initialize(){
        userService= UserServiceImpl.getInstance();
    }

    @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        loginAnchorPane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userLoginForm.fxml"));
            loginAnchorPane.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {
//

    }

}
