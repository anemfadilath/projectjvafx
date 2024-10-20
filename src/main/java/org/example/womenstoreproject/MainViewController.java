package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    private Stage stage;

    // Setter to set the stage reference
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("choise-page.fxml"));
            Parent root = loader.load();

            // Set the stage for the next controller
            ChoisePageController controller = loader.getController();
            controller.setStage(stage);  // Pass the stage

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
