package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ChoisePageController {

    private Stage stage;
   private String pass;
  @FXML
  private Button btnrevenue;
    public void setStage(Stage stage,String pass) {
        this.stage = stage;
        this.pass = pass;
        disbleButton();
    }
private void disbleButton() {
        if(this.pass.equals("user")){
            btnrevenue.setDisable(true);
        }
}

    @FXML
    public void handleButtonClothesClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display-page.fxml"));
            Parent root = loader.load();
            DisplayPageController controller = loader.getController();
            controller.setStage(stage,"Clothes",this.pass);
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
            controller.setStage(stage,"Shoes",this.pass);
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
            controller.setStage(stage,"Accesories",this.pass);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void icomeButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("income-page.fxml"));
            Parent root = loader.load();
            IncomePageController controller = loader.getController();
            controller.setStage(stage,this.pass);


            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void handleButtonBackToMainClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
            Parent root = loader.load();


            MainViewController mainController = loader.getController();
            mainController.setStage(stage);


            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
