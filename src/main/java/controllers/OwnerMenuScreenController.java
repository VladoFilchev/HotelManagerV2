package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.OwnerControllerServices;

public class OwnerMenuScreenController {
    OwnerControllerServices ownerControllerServices = new OwnerControllerServices();

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


    public void openCreateManager(ActionEvent event) {
        Scene scene = ownerControllerServices.getManagerCreationScene();
        setScene(scene, event);
    }
    public void openCreateHotel(ActionEvent event) {
        Scene scene = ownerControllerServices.getHotelCreationScene();
        setScene(scene, event);
    }
    private void setScene(Scene scene, ActionEvent event){
        if (scene != null) {
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.setTitle("HMS"); // Optional: set a title for the new window
            newStage.show(); // Show the new window
        }
    }
}
