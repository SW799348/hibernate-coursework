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
import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.dto.UserDTO;
import lk.ijse.hibernate.coursework.navigation.Navigation;
import lk.ijse.hibernate.coursework.navigation.Routes;
import lk.ijse.hibernate.coursework.service.impl.UserServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.UserService;

import java.io.IOException;
import java.util.List;


public class UserLoginFormController {

    @FXML
    private AnchorPane loginAnchorPane;
    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;


    private  UserService userService;



    public void initialize(){
       userService=UserServiceImpl.getInstance();
   }


    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        List<UserDTO> allUsers = userService.getAllUsers();
        for (UserDTO userDTO : allUsers) {
            if (userDTO.getUsername().equals(txtUsername.getText()) && userDTO.getPassword().equals(txtPassword.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, "login successfully!").showAndWait();
                Navigation.navigate(Routes.HOMEUSER, loginAnchorPane);

            }

        }
    }



    @FXML
    void SignUpOnAction(MouseEvent event) throws IOException {
       Navigation.navigate(Routes.USERSIGNUP, loginAnchorPane);
    }

}
