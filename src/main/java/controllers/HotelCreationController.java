package controllers;

import data.HotelDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import object.Hotel;


public class HotelCreationController {

    private final HotelDAO hotelDAO = new HotelDAO();

    @FXML
    private TextField hotelNameField;
    @FXML
    private Button createHotelButton;
    @FXML
    private Label feedbackLabel;

    @FXML
    public void initialize() {
        createHotelButton.setOnAction(this::onClick);
    }


    private boolean validateFields() {
        String hotelName = hotelNameField.getText().trim();


        // Validate all fields
        if (!isValidName(hotelName)) {
            showFeedback("Hotel name must contain only letters.", Color.RED);
            return false;
        }

        // If all validations pass
        showFeedback("Hotel created successfully!", Color.GREEN);

        return true;
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }



    private void showFeedback(String message, Color color) {
        feedbackLabel.setText(message);
        feedbackLabel.setTextFill(color);
    }

    private void clearFields() {
        hotelNameField.clear();

    }

    public void onClick(ActionEvent actionEvent) {
        String hotelName = hotelNameField.getText().trim();





        if(validateFields()) {
            System.out.println("\nHotel Name: " + hotelName);

            Hotel hotel = new Hotel((String)hotelName);

            System.out.println("First Name: " + hotel.getHotelName());

            hotelDAO.insertHotel(hotel);
            clearFields();
        }
    }
}
