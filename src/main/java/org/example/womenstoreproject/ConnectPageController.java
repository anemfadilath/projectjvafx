package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class ConnectPageController {
    @FXML
    private PasswordField txtpassword;
    private Stage stage;


    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void connectButtonClick(){
     if (txtpassword.getText().equals("User")){
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("choise-page.fxml"));
             Parent root = loader.load();


             ChoisePageController controller = loader.getController();
             controller.setStage(stage,"user");

             stage.setScene(new Scene(root));
             stage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }
     } else if (txtpassword.getText().equals("Admin")) {
         try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("choise-page.fxml"));
             Parent root = loader.load();


             ChoisePageController controller = loader.getController();
             controller.setStage(stage,"admin");

             stage.setScene(new Scene(root));
             stage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }

     }
     else new MessageController().showAlert("Invalid Password");

    }
    public void cancelButtonClick(){
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



