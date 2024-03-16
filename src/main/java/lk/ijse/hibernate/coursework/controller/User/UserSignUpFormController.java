package lk.ijse.hibernate.coursework.controller.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hibernate.coursework.controller.Admin.AdminLoginFormController;
import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.dto.UserDTO;
import lk.ijse.hibernate.coursework.navigation.Navigation;
import lk.ijse.hibernate.coursework.navigation.Routes;
import lk.ijse.hibernate.coursework.service.impl.AdminServiceImpl;
import lk.ijse.hibernate.coursework.service.impl.UserServiceImpl;
import lk.ijse.hibernate.coursework.service.inter.AdminService;
import lk.ijse.hibernate.coursework.service.inter.UserService;

import java.io.IOException;

public class UserSignUpFormController {

    private UserService userService;

    private AdminService adminService;



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
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/userLoginForm.fxml"));
            loginAnchorPane.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) throws IOException {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(txtUsername.getText());
        userDTO.setEmail(txtEmail.getText());
        userDTO.setPassword(txtPassword.getText());



        Long saveUser = userService.saveUser(userDTO);
        if(saveUser!=null){
            Navigation.navigate(Routes.USERLOGIN,loginAnchorPane);
            txtUsername.setText("");
            txtEmail.setText("");
            txtPassword.setText("");

        }else {
            new Alert(Alert.AlertType.ERROR).show();
        }

    }

}
