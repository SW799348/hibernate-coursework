package lk.ijse.hibernate.coursework.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    public static AnchorPane anchorPane;

    public static void navigate(Routes route, AnchorPane anchorPane) throws IOException {
        Navigation.anchorPane = anchorPane;
        Navigation.anchorPane.getChildren().clear();
        Stage window = (Stage) Navigation.anchorPane.getScene().getWindow();

        switch (route) {

            case ADMINLOGIN:
                initUI("adminLoginForm.fxml");
                window.setTitle("loginPage");
                break;

            case HOMEADMIN:
                initUI("adminDashboardForm.fxml");
                window.setTitle("Dashboard");
                break;


            case BOOKMANAGE:
                initUI("bookManageForm.fxml");
                window.setTitle("BookManage");
                break;

            case BRANCHMANAGE:
                initUI("branchManageForm.fxml");
                window.setTitle("BranchManage");
                break;

            case USERMANAGE:
                initUI("userManageForm.fxml");
                window.setTitle("UserManage");
                break;

            case USERSIGNUP:
                initUI("userSignUpForm.fxml");
                window.setTitle("SignUp");
                break;

            case USERLOGIN:
                initUI("userLoginForm.fxml");
                window.setTitle("loginPage");
                break;

            case HOMEUSER:
                initUI("dashboardUserForm.fxml");
                window.setTitle("Dashboard");
                break;

            case BORROWBOOKS:
                initUI("borrowBooksForm.fxml");
                window.setTitle("BorrowBooks");
                break;


            case SEARCHBOOKS:
                initUI("searchBooksForm.fxml");
                window.setTitle("SearchBooks");
                break;

            case VIEWTRANSACTION:
                initUI("returnBooksForm.fxml");
                window.setTitle("Transaction");
                break;

            case USERSETTING:
                initUI("userSettingForm.fxml");
                window.setTitle("UserSetting");
                break;

        }

    }

    private static void initUI(String location) throws IOException {
        Navigation.anchorPane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/view/" + location)));
    }
}
