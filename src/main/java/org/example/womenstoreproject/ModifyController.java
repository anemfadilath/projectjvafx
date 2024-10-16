package org.example.womenstoreproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ModifyController {

    @FXML
    private Button btnmodify;

    @FXML
    private TextField txtname;
    @FXML
    private TextField txtsize;
    @FXML
    private TextField txtsellprice;
    private Clothes selectedClothe;
    private Shoes selectedShoe;
    private Accessories selectedAccessorie;
    private Stage stage;
    private String category;

    public void setStage(Stage stage,String category) {
        this.stage = stage;
        this.category = category;
        disableSizeField(category);
    }

    private  void disableSizeField(String category){
        if (category.equals("Accesories")){
            txtsize.setVisible(false);
        }
    }

    public void setSelectedProduct(Product selectedProduct) {
        switch (this.category) {
            case "Clothes" -> {
                this.selectedClothe = (Clothes) selectedProduct;
                txtname.setText(this.selectedClothe.getName());
                txtsellprice.setText(String.valueOf(this.selectedClothe.getSellPrice()));
                txtsize.setText(String.valueOf(this.selectedClothe.getSize()));
            }
            case "Shoes" -> {
                this.selectedShoe = (Shoes) selectedProduct;
                txtname.setText(this.selectedShoe.getName());
                txtsellprice.setText(String.valueOf(this.selectedShoe.getSellPrice()));
                txtsize.setText(String.valueOf(this.selectedShoe.getShoeSize()));
            }
            case "Accesories" -> {
                this.selectedAccessorie = (Accessories) selectedProduct;
                txtname.setText(this.selectedAccessorie.getName());
                txtsellprice.setText(String.valueOf(this.selectedAccessorie.getSellPrice()));
            }
        }
    }
    @FXML
    public void saveButtonClick() throws SQLException {
        switch (this.category) {
            case "Clothes" -> {
                this.selectedClothe.setName(txtname.getText());
                this.selectedClothe.setSellPrice(Double.parseDouble(txtsellprice.getText()));
                this.selectedClothe.setSize(Integer.parseInt(txtsize.getText()));
                UpdateOperation updateOperation = new UpdateOperation();
                updateOperation.updateClothes(this.selectedClothe);
            }
            case "Shoes" -> {
                this.selectedShoe.setName(txtname.getText());
                this.selectedShoe.setSellPrice(Double.parseDouble(txtsellprice.getText()));
                this.selectedShoe.setShoeSize(Integer.parseInt(txtsize.getText()));
                UpdateOperation updateOperation = new UpdateOperation();
                updateOperation.updateShoes(this.selectedShoe);

            }
            case "Accesories" -> {
                this.selectedAccessorie.setName(txtname.getText());
                this.selectedAccessorie.setSellPrice(Double.parseDouble(txtsellprice.getText()));
                UpdateOperation updateOperation = new UpdateOperation();
                updateOperation.updateAccessories(this.selectedAccessorie);

            }
        }
    }
    private void returnTopage(Stage stage) throws IOException {

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
    public  void returnButtonClick() throws SQLException {
        switch (category) {
            case "Clothes" -> returnToPage("Clothes");
            case "Shoes" -> returnToPage("Shoes");
            case "Accesories" -> returnToPage("Accesories");
        }
    }
}