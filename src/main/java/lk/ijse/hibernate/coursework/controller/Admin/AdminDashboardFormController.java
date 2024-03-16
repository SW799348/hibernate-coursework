package lk.ijse.hibernate.coursework.controller.Admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.coursework.navigation.Navigation;
import lk.ijse.hibernate.coursework.navigation.Routes;

import java.io.IOException;

public class AdminDashboardFormController {

    @FXML
    private AnchorPane subAnchorPane;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TextField txtSearch;
    @FXML
    private JFXButton btnBook;

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnBranch;

    @FXML
    private JFXButton btnSignout;

    @FXML
    private JFXButton btnTransactions;

    @FXML
    private JFXButton btnUser;
    public void initialize() {
        events();
        actions();

    }

    private void events() {
        btnHome.setOnMouseClicked(mouseEvent -> {
            btnHome.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius: 10 0 0 10;-fx-border-radius:10 0 0 10");
            btnBook.setStyle("");
            btnUser.setStyle("");
            btnBranch.setStyle("");
            btnTransactions.setStyle("");

        });

        btnBook.setOnMouseClicked(mouseEvent -> {
            btnBook.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius: 10 0 0 10;-fx-border-radius:10 0 0 10");
            btnHome.setStyle("");
            btnUser.setStyle("");
            btnBranch.setStyle("");
            btnTransactions.setStyle("");

        });
        btnUser.setOnMouseClicked(mouseEvent -> {
            btnUser.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius: 10 0 0 10;-fx-border-radius:10 0 0 10");
            btnBook.setStyle("");
            btnHome.setStyle("");
            btnBranch.setStyle("");
            btnTransactions.setStyle("");

        });

        btnBranch.setOnMouseClicked(mouseEvent -> {
            btnBranch.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius: 10 0 0 10;-fx-border-radius:10 0 0 10");
            btnBook.setStyle("");
            btnUser.setStyle("");
            btnHome.setStyle("");
            btnTransactions.setStyle("");

        });

        btnTransactions.setOnMouseClicked(mouseEvent -> {
            btnTransactions.setStyle("-fx-background-color: rgb(255,255,255);-fx-background-radius: 10 0 0 10;-fx-border-radius:10 0 0 10");
            btnBook.setStyle("");
            btnUser.setStyle("");
            btnBranch.setStyle("");
            btnHome.setStyle("");

        });
    }

    private void actions() {
        btnHome.setOnAction(actionEvent -> {
            try {
                Navigation.navigate(Routes.HOMEADMIN,mainAnchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnBook.setOnAction(actionEvent -> {
            try {
                Navigation.navigate(Routes.BOOKMANAGE,subAnchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        btnUser.setOnAction(actionEvent -> {
            try {
                Navigation.navigate(Routes.USERMANAGE,subAnchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnBranch.setOnAction(actionEvent -> {
            try {
                Navigation.navigate(Routes.BRANCHMANAGE,subAnchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        btnTransactions.setOnAction(actionEvent -> {
            try {
                Navigation.navigate(Routes.VIEWTRANSACTION,subAnchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnSignout.setOnMouseClicked(mouseEvent -> {
            Parent rootNode = null;
            try {
                rootNode = FXMLLoader.load(this.getClass().getResource("/view/adminLoginForm.fxml"));
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




    @FXML
    void btnSearch(ActionEvent event) {

    }


}
