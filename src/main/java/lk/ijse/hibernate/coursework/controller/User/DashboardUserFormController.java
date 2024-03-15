package lk.ijse.hibernate.coursework.controller.User;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.hibernate.coursework.navigation.Navigation;
import lk.ijse.hibernate.coursework.navigation.Routes;

import java.io.IOException;

public class DashboardUserFormController {

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnMyBooks;

    @FXML
    private JFXButton btnRetun;

    @FXML
    private JFXButton btnSettings;

    @FXML
    private JFXButton btnSignOut;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private AnchorPane subAnchorPane;

    @FXML
    private TextField txtSearch;

    public void initialize() {
        events();
        actions();

    }

    private void actions() {

        btnHome.setOnAction(actionEvent -> {
            try {
                Navigation.navigate(Routes.HOMEUSER,mainAnchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnMyBooks.setOnAction(actionEvent -> {
            try {
                Navigation.navigate(Routes.BORROWBOOKS,subAnchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        btnRetun.setOnAction(actionEvent -> {
            try {
                Navigation.navigate(Routes.VIEWTRANSACTION,subAnchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnSettings.setOnAction(actionEvent -> {
            try {
                Navigation.navigate(Routes.USERSETTING,subAnchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnSignOut.setOnMouseClicked(mouseEvent -> {
            Parent rootNode = null;
            try {
                rootNode = FXMLLoader.load(this.getClass().getResource("/view/User/userLoginForm.fxml"));
                Scene scene = new Scene(rootNode);

                mainAnchorPane.getChildren().clear();
                Stage primaryStage = (Stage) mainAnchorPane.getScene().getWindow();

                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();
                primaryStage.setTitle("DashBoard");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        });

    }

    private void events() {
        btnHome.setOnMouseClicked(mouseEvent -> {
            btnHome.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius: 10 0 0 10;-fx-border-radius:10 0 0 10");
            btnMyBooks.setStyle("");
            btnRetun.setStyle("");
            btnSettings.setStyle("");


        });
        btnMyBooks.setOnMouseClicked(mouseEvent -> {
            btnMyBooks.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius: 10 0 0 10;-fx-border-radius:10 0 0 10");
            btnHome.setStyle("");
            btnRetun.setStyle("");
            btnSettings.setStyle("");


        });
        btnRetun.setOnMouseClicked(mouseEvent -> {
            btnRetun.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius: 10 0 0 10;-fx-border-radius:10 0 0 10");
            btnMyBooks.setStyle("");
            btnHome.setStyle("");
            btnSettings.setStyle("");


        });
        btnSettings.setOnMouseClicked(mouseEvent -> {
            btnSettings.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius: 10 0 0 10;-fx-border-radius:10 0 0 10");
            btnMyBooks.setStyle("");
            btnRetun.setStyle("");
            btnHome.setStyle("");


        });
    }

    @FXML
    void btnSearch(ActionEvent event) {

    }

}
