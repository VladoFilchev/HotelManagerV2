package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.AdminControllerServices;

public class AdminMenuScreenController {
    AdminControllerServices adminControllerServices = new AdminControllerServices();

    @FXML
    private Text greetingText;

    @FXML
    private Button managersMenu;

    @FXML
    private Button ownersMenu;

    @FXML
    private Pane pangeObj;

    @FXML
    private Button receptionistsMenu;


    public void openCreateOwner(ActionEvent event) {
        Scene scene = adminControllerServices.getMenuScene();

            if (scene != null) {
                Stage newStage = new Stage();
                newStage.setScene(scene);
                newStage.setTitle("HMS"); // Optional: set a title for the new window
                newStage.show(); // Show the new window
        }

    }

}
