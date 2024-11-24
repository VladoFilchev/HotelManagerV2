package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.ManagerDAO;
import data.OwnerDAO;
import data.ReceptionistDAO;
import enums.UserType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ControllerServices {
    private OwnerDAO ownerDAO=new OwnerDAO();
    private ManagerDAO managerDAO=new ManagerDAO();
    private ReceptionistDAO receptionistDAO=new ReceptionistDAO();
    private final String ownerMenu = "/com/example/hotelmanager/screens/OwnerMenuScreen.fxml";
    private final String managerMenu = "/com/example/hotelmanager/screens/ManagerMenuScreen.fxml";
    private final String receptionistMenu = "/com/example/hotelmanager/screens/ReceptionistMenuScreen.fxml";

    public Scene getMainScene(UserType userType) {

        String fxmlFile = null;

        FXMLLoader loader;
        switch (userType) {
            case OWNER -> fxmlFile = ownerMenu;
            case MANAGER -> fxmlFile = managerMenu;
            case RECEPTIONIST -> fxmlFile = receptionistMenu;
            default -> throw new IllegalStateException("Unexpected access level for ADMIN: " + userType);
        }

        try {
            loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load(); // Load the FXML into the root node
            return new Scene(root); // Return the new scene with the loaded root
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle the error appropriately in your application
        }

    }

    public boolean verifyLogin(String username, String password, UserType userType) {
        if (userType == UserType.OWNER) {
            return ownerDAO.authenticateUser(username, password);
        } else if (userType == UserType.MANAGER) {
            return managerDAO.authenticateUser(username, password);
        } else if (userType == UserType.RECEPTIONIST) {
            return receptionistDAO.authenticateUser(username, password);
        } else {
            return false;
        }
    }
}
