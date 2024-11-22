package services;

import enums.UserType;
import javafx.fxml.FXMLLoader;
import object.LoggedInUser;

public class ControllerServices {
    public FXMLLoader getMainScene(LoggedInUser loggedInUser) {
        FXMLLoader loader;
        if (loggedInUser.getUserType() == UserType.ADMIN) {
            switch (loggedInUser.getAccessLevel()) {
                case 2 -> loader = new FXMLLoader(getClass().getResource("/com/hotelmanager/AdminMenuScreen.fxml"));
                case 1 -> loader = new FXMLLoader(getClass().getResource("/com/hotelmanager/ManagerMenuScreen.fxml"));
                default ->
                        throw new IllegalStateException("Unexpected access level for ADMIN: " + loggedInUser.getAccessLevel());
            }
        } else if (loggedInUser.getUserType() == UserType.USER) {
            loader = new FXMLLoader(getClass().getResource("/com/hotelmanager/ReceptionistMenuScreen.fxml"));
        } else {
            throw new IllegalStateException("Unexpected user type: " + loggedInUser.getUserType());
        }
        return loader;
    }
}
