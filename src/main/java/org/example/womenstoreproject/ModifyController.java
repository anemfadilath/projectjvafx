package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ModifyController {

    @FXML
    private Button btnmodify;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtsellprice;
    private Clothes selectedClothe;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSelectedProduct(Clothes selectedClothe) {
        this.selectedClothe = selectedClothe;
        txtname.setText(selectedClothe.getName());
        txtsellprice.setText(String.valueOf(selectedClothe.getSellPrice()));
    }
    @FXML
    private void saveButtonClick() throws SQLException {
        selectedClothe.setName(txtname.getText());
        selectedClothe.setSellPrice(Double.parseDouble(txtsellprice.getText()));
        UpdateOperation updateOperation = new UpdateOperation();
        updateOperation.updateClothes(selectedClothe);
    }
}