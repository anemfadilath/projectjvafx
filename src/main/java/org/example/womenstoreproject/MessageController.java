package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class MessageController {
    @FXML
     void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
     void showMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Operation Done Successfully");
        alert.showAndWait();
    }
}
