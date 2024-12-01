package controllers;

import data.ClientDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import object.Client;


public class PersonFormController {
    private Client client;
    private ClientDAO clientDAO ;
    @FXML
    public TextField nameField;
    @FXML
    public TextField surnameField;
    @FXML
    public TextField phoneField;
    @FXML
    public DatePicker dobField;
    @FXML
    public Button cancelButton;

    @FXML
    private Label errorLabel;


    public void add() {
        //validate
        if (isValidInput()) {
            System.out.println(nameField.getText());
            client = new Client(nameField.getText().trim(), surnameField.getText().trim(), dobField.getValue(), phoneField.getText().trim());


            clientDAO = new ClientDAO();
            clientDAO.saveClientToDb(client);

            // return
        }

    }

    private boolean isValidInput() {
        StringBuilder errorMessage = new StringBuilder();

        if (nameField.getText() == null || nameField.getText().trim().isEmpty()) {
            errorMessage.append("Name is required.\n");
        } else if (!nameField.getText().matches("[A-Za-z ]+")) {
            errorMessage.append("Name must only contain letters\n");
        }

        // Validate Surname
        if (surnameField.getText() == null || surnameField.getText().trim().isEmpty()) {
            errorMessage.append("Surname is required.\n");
        } else if (!surnameField.getText().matches("[A-Za-z ]+")) {
            errorMessage.append("Surname must only contain letters\n");
        }

        // Validate Phone
        if (phoneField.getText() == null || !phoneField.getText().matches("\\d{10}")) {
            errorMessage.append("Phone must be a 10-digit number.\n");
        }

        // Validate Date of Birth
        if (dobField.getValue() == null) {
            errorMessage.append("Date of birth is required.\n");
        } else if (dobField.getValue().isAfter(java.time.LocalDate.now())) {
            errorMessage.append("Date of birth must be in the past.\n");
        }
        if (errorMessage.length() > 0) {
            System.out.println(errorMessage.toString());
            showErrorMessage(errorMessage.toString());
            return false;
        }

        return true;
    }
    private void showErrorMessage(String message) {
        errorLabel.setText(message); // Set the error message
        errorLabel.setVisible(true); // Make the label visible
    }
    public void cancel() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
