package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerMenuController {

    @FXML
    private Text greetingText;

    @FXML
    private Pane pangeObj;

    @FXML
    private Button receptionistsMenu;

    @FXML
    private void openReceptionistRegistration(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hotelmanager/screens/ReceptionistRegistrationScreen.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage(); // open in new window
            stage.setTitle("Receptionist Registration");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Consider logging this
        }
    }
}
