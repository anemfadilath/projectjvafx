package org.example.womenstoreproject;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
        System.out.println(category);
        disableSizeField(category);
    }
    @FXML
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
   @FXML
   public  void disableSizeField(String category){
        if (category.equals("Accesories")){
            txtsize.setDisable(true);
        }
   }
    private void createClothes() throws SQLException {
        try {
            Clothes newClothes = new Clothes(txtname.getText(), Double.parseDouble(txtpurchaseprice.getText()), Double.parseDouble(txtsellprice.getText()), Integer.parseInt(txtsize.getText()));
            CreateOperation createOperation = new CreateOperation();
            createOperation.insertIntoClothes(newClothes);
        }catch(IllegalArgumentException e){
            showAlert(e.getMessage());
        }

    }
    private void createShoes() throws SQLException {
        try {
            Shoes newShoes = new Shoes(txtname.getText(), Double.parseDouble(txtpurchaseprice.getText()), Double.parseDouble(txtsellprice.getText()), Integer.parseInt(txtsize.getText()));
            CreateOperation createOperation = new CreateOperation();
            createOperation.insertIntoShoes(newShoes);
        }catch(IllegalArgumentException e){
            showAlert(e.getMessage());
        }
    }
    private void createAccesories() throws SQLException {
        try {
            Accessories newAccessories = new Accessories(txtname.getText(), Double.parseDouble(txtpurchaseprice.getText()), Double.parseDouble(txtsellprice.getText()));
            CreateOperation createOperation = new CreateOperation();
            createOperation.insertIntoAccessories(newAccessories);
        }catch(IllegalArgumentException e){
            showAlert(e.getMessage());
        }
    }
    private void returnToPage(String category) throws SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("display-page.fxml"));
            Parent root = loader.load();
            DisplayPageController controller = loader.getController();
            controller.setStage(stage,category);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnButtonClick() throws SQLException {
        if(category.equals("Clothes")){
            returnToPage("Clothes");


        }
        else if(category.equals("Shoes")){
            returnToPage("Shoes");

        }
        else if (category.equals("Accesories")){
            returnToPage("Accesories");
        }
    }
    public void createButtonClick() throws SQLException {

        if(category.equals("Clothes")){
            createClothes();


        }
        else if(category.equals("Shoes")){
            createShoes();

        }
       else if (category.equals("Accesories")){

            createAccesories();
        }
    }
    }
