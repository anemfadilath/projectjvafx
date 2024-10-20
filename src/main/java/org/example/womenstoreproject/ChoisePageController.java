package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ChoisePageController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleButtonClothesClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display-page.fxml"));
            Parent root = loader.load();
            DisplayPageController controller = loader.getController();
            controller.setStage(stage,"Clothes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void handleButtonShoesClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display-page.fxml"));
            Parent root = loader.load();
            DisplayPageController controller = loader.getController();
            controller.setStage(stage,"Shoes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleButtonAccesoriesClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display-page.fxml"));
            Parent root = loader.load();
            DisplayPageController controller = loader.getController();
            controller.setStage(stage,"Accesories");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void icomeButtonClick(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("income-page.fxml"));
            Parent root = loader.load();
            IncomePageController controller = loader.getController();
            controller.setStage(stage);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
