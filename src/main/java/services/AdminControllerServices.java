package services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AdminControllerServices {
    private final String ownerMenu = "/com/example/hotelmanager/screens/OwnerCreationScreen.fxml";

    public Scene getMenuScene(){
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(getClass().getResource(ownerMenu));
            Parent root= loader.load();
            return new Scene(root);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
