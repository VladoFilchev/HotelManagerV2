package controllers;

import enums.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ControllerServices;

import java.io.IOException;

public class LoginScreenController {

    private final ControllerServices controllerServices = new ControllerServices();

    private FXMLLoader loader;
    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private VBox root;

    @FXML
    private TextField usernameField;

    @FXML
    private Text loginText;


    @FXML
    private ComboBox<UserType> typeBox;

    public void initialize() {
        // Populate the ComboBox with UserType values
        typeBox.getItems().setAll(UserType.values()); // Populate the ComboBox with the enum values
    }


    public void handleLogin(ActionEvent actionEvent) throws IOException {
        {

            String username = usernameField.getText();
            String password = passwordField.getText();
            UserType userType = typeBox.getValue();


            if (!controllerServices.verifyLogin(username, password, userType)) {
                loginText.setText("username or password is incorrect");
                passwordField.setText("");
            } else {
               Scene scene = controllerServices.getMainScene(userType);

                if (scene != null) {
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene); // Switch to the new scene
                    stage.show(); // Display the stage with the new scene
                } else {
                    loginText.setText("Error loading the scene.");
                }
            }

        }
    }
}


