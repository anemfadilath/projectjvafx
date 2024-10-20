package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SaleController {

    @FXML
    private Stage stage;
    public void sallebutton () {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("choise-page.fxml"));
            Parent root = loader.load();
            ChoisePageController controller = loader.getController();

            controller.setStage(stage,"");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

