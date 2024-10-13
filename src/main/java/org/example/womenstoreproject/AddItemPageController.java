package org.example.womenstoreproject;



import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddItemPageController {

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtpurchaseprice;

    @FXML
    private TextField txtsellprice;

    @FXML
    private TextField txtsize;
    private Stage stage;
    private String category;

    public void setStage(Stage stage,String category) {
        this.stage = stage;
        this.category = category;
    }
    @FXML
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void createClothes() throws SQLException {
        try {
            Clothes newClothes = new Clothes(txtname.getText(), Double.parseDouble(txtpurchaseprice.getText()), Double.parseDouble(txtsellprice.getText()), Integer.parseInt(txtsize.getText()));
            CreateOperation createOperation = new CreateOperation();
            createOperation.insertIntoClothes(newClothes);
        }catch(IllegalArgumentException e){
            showAlert(e.getMessage());
        }

    }
    public void createShoes() throws SQLException {
        try {
            Shoes newShoes = new Shoes(txtname.getText(), Double.parseDouble(txtpurchaseprice.getText()), Double.parseDouble(txtsellprice.getText()), Integer.parseInt(txtsize.getText()));
            CreateOperation createOperation = new CreateOperation();
            createOperation.insertIntoShoes(newShoes);
        }catch(IllegalArgumentException e){
            showAlert(e.getMessage());
        }
    }
    public void createButtonClick() throws SQLException {
        if(category.equals("Clothes")){
            createClothes();
        }
        else if(category.equals("Shoes")){
            createShoes();
        }
    }
    }
