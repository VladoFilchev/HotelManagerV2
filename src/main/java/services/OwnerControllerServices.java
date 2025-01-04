package services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class OwnerControllerServices {
    private String sceneName = "";

    public Scene returnScene(){
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(getClass().getResource(sceneName));
            Parent root= loader.load();
            return new Scene(root);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Scene getHotelCreationScene() {
        sceneName = "/com/example/hotelmanager/screens/HotelCreationScreen.fxml";
        return returnScene();
    }

    public Scene getManagerCreationScene() {
        sceneName = "/com/example/hotelmanager/screens/ManagerCreationScreen.fxml";
        return returnScene();
    }
}
