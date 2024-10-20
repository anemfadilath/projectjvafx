package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class IncomePageController {

    @FXML
    private Label incomeLabel;

    @FXML
    private Label costLabel;

    @FXML
    private Label capitalLabel;

    private Stage stage;
    private String user;
    public void setStage(Stage stage,String user) throws SQLException {
        this.stage = stage;
        this.user = user;
        initialize();
    }

    @FXML
    public void initialize() throws SQLException {

        double[] incomeData = new SelectOperations().selectIncome();


        incomeLabel.setText(String.valueOf(incomeData[0]));
        costLabel.setText(String.valueOf(incomeData[1]));
        capitalLabel.setText(String.valueOf(incomeData[2]));
    }
    public void returnButtonClick(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("choise-page.fxml"));
            Parent root = loader.load();


            ChoisePageController controller = loader.getController();
            controller.setStage(stage,this.user);

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
