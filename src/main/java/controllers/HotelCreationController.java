package controllers;
import data.HotelDAO;
import enums.RoomStatus;
import enums.RoomType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import object.Hotel;
import javafx.scene.control.*;
import object.*;
import services.HotelService;
import services.UserService;
import java.util.ArrayList;
import java.util.List;

public class HotelCreationController {

    @FXML private TextField hotelNameField;
    @FXML private ComboBox<Manager> managerComboBox;
    @FXML private Button addRoomButton;
    @FXML private Button createHotelButton;
    @FXML private ListView<String> roomListView;
    @FXML private Label feedbackLabel;

    HotelDAO hotelDAO = new HotelDAO();

    private List<Room> hotelRooms = new ArrayList<>();

    @FXML
    public void initialize() {
        managerComboBox.getItems().addAll(UserService.getAllManagers());
        addRoomButton.setOnAction(e -> addRoomDialog());
        createHotelButton.setOnAction(e -> createHotel());
    }

    private void addRoomDialog() {
        Dialog<Room> dialog = new Dialog<>();
        dialog.setTitle("Add Room");

        TextField roomNumber = new TextField();
        ComboBox<RoomType> typeCombo = new ComboBox<>();
        ComboBox<RoomStatus> statusCombo = new ComboBox<>();
        typeCombo.getItems().addAll(RoomType.values());
        statusCombo.getItems().addAll(RoomStatus.values());

        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10);
        grid.add(new Label("Room Number:"), 0, 0);
        grid.add(roomNumber, 1, 0);
        grid.add(new Label("Room Type:"), 0, 1);
        grid.add(typeCombo, 1, 1);
        grid.add(new Label("Room Status:"), 0, 2);
        grid.add(statusCombo, 1, 2);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        dialog.setResultConverter(button -> {
            if (button == ButtonType.OK) {
                Room room = new Room();
                room.setRoomNumber(Integer.parseInt(roomNumber.getText()));
                room.setRoomType(typeCombo.getValue());
                room.setPrice(typeCombo.getValue().getPricePerNight());
                room.setRoomStatus(statusCombo.getValue());
                return room;
            }
            return null;
        });

        dialog.showAndWait().ifPresent(room -> {
            hotelRooms.add(room);
            roomListView.getItems().add("Room " + room.getRoomNumber() + " - " + room.getRoomType() + " - " +room.getRoomType().getPricePerNight() +"$");
        });
    }

    private void createHotel() {
        String name = hotelNameField.getText();
        Manager selectedManager = managerComboBox.getValue();

        if (name.isEmpty() || selectedManager == null || hotelRooms.isEmpty()) {
            feedbackLabel.setText("Please fill all fields and add at least one room.");
            return;
        }

        if(hotelDAO.authenticateHotel(name)) {
            feedbackLabel.setText("Hotel with this name already exists.");
            return;
        }

        Hotel hotel = new Hotel();
        hotel.setHotelName(name);
        hotel.setHotelManager(selectedManager);
        hotel.setHotelRoomsList(hotelRooms);
        hotel.setHotelOwner(CurrentSession.getAsOwner()); // assuming current user context

        boolean success = HotelService.saveHotel(hotel);
        if (success) {
            feedbackLabel.setText("Hotel created successfully!");
        } else {
            feedbackLabel.setText("Error creating hotel.");
        }
    }
}


