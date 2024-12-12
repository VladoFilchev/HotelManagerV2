package controllers;

import data.OwnerDAO;
import enums.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import object.Owner;

import java.time.LocalDate;

public class OwnerCreationController {
    private final OwnerDAO ownerDAO = new OwnerDAO();

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button createOwnerButton;

    @FXML
    private Label feedbackLabel;

    @FXML
    public void initialize() {
        createOwnerButton.setOnAction(this::onClick);
    }

    private boolean validateFields() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        LocalDate dob = dobPicker.getValue();
        String phoneNumber = phoneNumberField.getText().trim();
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        // Validate all fields
        if (!isValidName(firstName)) {
            showFeedback("First name must contain only letters.", Color.RED);
            return false;
        }

        if (!isValidName(lastName)) {
            showFeedback("Last name must contain only letters.", Color.RED);
            return false;
        }

        if (!isValidDateOfBirth(dob)) {
            showFeedback("Date of birth must be a valid date before today.", Color.RED);
            return false;
        }

        if (!isValidPhoneNumber(phoneNumber)) {
            showFeedback("Phone number must be exactly 10 digits.", Color.RED);
            return false;
        }

        if (!isValidUsername(username)) {
            showFeedback("Username must be alphanumeric and at most 12 characters.", Color.RED);
            return false;
        }

        if (!isValidPassword(password)) {
            showFeedback("Password must be longer than 5 characters.", Color.RED);
            return false;
        }

        // If all validations pass
        showFeedback("Owner created successfully!", Color.GREEN);

        return true;
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private boolean isValidDateOfBirth(LocalDate dob) {
        return dob != null && dob.isBefore(LocalDate.now());
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }

    private boolean isValidUsername(String username) {
        return username.matches("[a-zA-Z0-9]{1,12}");
    }

    private boolean isValidPassword(String password) {
        return password.length() > 5;
    }

    private void showFeedback(String message, Color color) {
        feedbackLabel.setText(message);
        feedbackLabel.setTextFill(color);
    }

    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        dobPicker.setValue(null);
        phoneNumberField.clear();
        usernameField.clear();
        passwordField.clear();
    }

    public void onClick(ActionEvent actionEvent) {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        LocalDate dob = dobPicker.getValue();
        String phoneNumber = phoneNumberField.getText().trim();
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();




        if(validateFields()) {
            System.out.println("\nFirst Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Date of Birth: " + dob);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Username: " + username+"\n");

            Owner owner = new Owner(firstName,lastName,dob,phoneNumber,0,password,null,username,UserType.OWNER);

            System.out.println("First Name: " + owner.getFirstName());
            System.out.println("Last Name: " + owner.getLastName());
            System.out.println("Date of Birth: " + owner.getDateOfBirth());
            System.out.println("Phone Number: " + owner.getPhoneNumber());
            System.out.println("Username: " + owner.getUsername()+"\n");

            ownerDAO.insertOwner(owner);
            clearFields();
        }
    }
}
