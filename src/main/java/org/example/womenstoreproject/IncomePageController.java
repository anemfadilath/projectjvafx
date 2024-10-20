package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.SQLException;

public class IncomePageController {

    @FXML
    private Label incomeLabel;

    @FXML
    private Label costLabel;

    @FXML
    private Label capitalLabel;

    private Stage stage;

    public void setStage(Stage stage) throws SQLException {
        this.stage = stage;
        initialize();
    }

    @FXML
    public void initialize() throws SQLException {

        double[] incomeData = new SelectOperations().selectIncome();


        incomeLabel.setText(String.valueOf(incomeData[0]));
        costLabel.setText(String.valueOf(incomeData[1]));
        capitalLabel.setText(String.valueOf(incomeData[2]));
    }
}
