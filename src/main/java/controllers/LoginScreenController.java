package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import object.LoggedInUser;
import services.ControllerServices;

import java.io.IOException;

public class LoginScreenController {
    private ControllerServices controllerServices;
    //private final LoggedInUser loggedInUser;
    private FXMLLoader loader;
    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private VBox root;

    @FXML
    private TextField usernameField;

    public LoginScreenController() {

    }

//    public void loadDashboard(Stage stage) throws IOException {
//
//       loader = controllerServices.getMainScene(loggedInUser);
//
//        Parent dashboard = loader.load();
//        Scene scene = new Scene(dashboard);
//        stage.setScene(scene);
//        stage.show();
//        // Load the FXML and set it as the root of the scene
//    }


    public void handleLogin(ActionEvent actionEvent) {

    }
}


