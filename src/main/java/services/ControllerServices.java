package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.AdminUserDAO;
import data.ManagerDAO;
import data.OwnerDAO;
import data.ReceptionistDAO;
import enums.UserType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import object.Hotel;
import object.Owner;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ControllerServices {
    private OwnerDAO ownerDAO = new OwnerDAO();
    private ManagerDAO managerDAO = new ManagerDAO();
    private ReceptionistDAO receptionistDAO = new ReceptionistDAO();
    private AdminUserDAO adminUserDAO = new AdminUserDAO();
    private final String ownerMenu = "/com/example/hotelmanager/screens/OwnerMenuScreen.fxml";
    private final String managerMenu = "/com/example/hotelmanager/screens/ManagerMenuScreen.fxml";
    private final String receptionistMenu = "/com/example/hotelmanager/screens/ReceptionistMenuScreen.fxml";
    private final String adminMenu = "/com/example/hotelmanager/screens/AdminMenuScreen.fxml";

    public Scene getMainScene(UserType userType) {

        String fxmlFile = null;

        FXMLLoader loader;
        switch (userType) {
            case OWNER -> fxmlFile = ownerMenu;
            case MANAGER -> fxmlFile = managerMenu;
            case RECEPTIONIST -> fxmlFile = receptionistMenu;
            case ADMIN -> fxmlFile = adminMenu;
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
        } else if (userType == UserType.ADMIN) {
            return adminUserDAO.authenticateUser(username, password);
        } else {
            return false;
        }
    }

    public Owner createOwner(String firstName, String lastName, LocalDate dateOfBirth, String phoneNumber, String username, String password, List<Hotel> hotelList) {

        return new Owner(firstName,lastName,dateOfBirth,phoneNumber,0,password,hotelList,username);
    }
}
