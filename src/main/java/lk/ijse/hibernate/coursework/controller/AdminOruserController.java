package lk.ijse.hibernate.coursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminOruserController {

    @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    void btnAdminOnAction(ActionEvent event) throws IOException {

        Parent loginAnchorPane = FXMLLoader.load(this.getClass().getResource("/view/AdminLoginForm.fxml"));

        Scene scene = new Scene(loginAnchorPane);
        Stage stage = (Stage) this.loginAnchorPane.getScene().getWindow();

        stage.setTitle("Admin");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    @FXML
    void btnUserOnAction(ActionEvent event) throws IOException {
        Parent loginAnchorPane = FXMLLoader.load(this.getClass().getResource("/view/UserLoginForm.fxml"));

        Scene scene = new Scene(loginAnchorPane);
        Stage stage = (Stage) this.loginAnchorPane.getScene().getWindow();

        stage.setTitle("User");
        stage.setScene(scene);
        stage.centerOnScreen();
    }

}
