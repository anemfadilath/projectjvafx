package org.example.womenstoreproject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class DisplayPageController {
    private Stage stage;
    private String category;

    public void setStage(Stage stage,String category) throws SQLException {
        this.stage = stage;
        this.category = category;
        listProducts();
    }
    @FXML
    private ListView<Product> productListView;

    @FXML
    private Text txtdiscounted;

    @FXML
    private Text txtname;

    @FXML
    private Text txtpurchaseprice;

    @FXML
    private Text txtsellprice;

    @FXML
    private Text txtsize;

    @FXML
    private Text txtstock;
    @FXML
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML



    public void listProducts() throws SQLException {
        if (category != null) {
            if (category.equals("Clothes")) {
                productListView.setItems(SelectOperations.selectClothes());
                productListView.setOnMouseClicked(this::clothesClick);
            } else if (category.equals("Shoes")) {
                productListView.setItems(SelectOperations.selectShoes());
                productListView.setOnMouseClicked(this::shoesClick);
            }
        }
    }

    private void clothesClick(MouseEvent event) {
        Clothes selectedProduct = (Clothes) productListView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {

            txtname.setText(selectedProduct.getName());
            txtpurchaseprice.setText(String.valueOf(selectedProduct.getPurchasePrice()));
            txtsellprice.setText(String.valueOf(selectedProduct.getSellPrice()));
            txtsize.setText(String.valueOf(selectedProduct.getSize()));
            txtstock.setText(String.valueOf(selectedProduct.getNumberOfItems()));
            txtdiscounted.setText(String.valueOf(selectedProduct.getDiscountPrice()));
        }
    }
    private void shoesClick(MouseEvent event) {
        Shoes selectedShoe = (Shoes) productListView.getSelectionModel().getSelectedItem();
        if (selectedShoe != null) {

            txtname.setText(selectedShoe.getName());
            txtpurchaseprice.setText(String.valueOf(selectedShoe.getPurchasePrice()));
            txtsellprice.setText(String.valueOf(selectedShoe.getSellPrice()));
            txtsize.setText(String.valueOf(selectedShoe.getShoeSize()));
            txtstock.setText(String.valueOf(selectedShoe.getNumberOfItems()));
            txtdiscounted.setText(String.valueOf(selectedShoe.getDiscountPrice()));
        }
    }
    public void handleButtonClick() {
        try {
            //load the add-item-page by passing the cathegory in it's parameters
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add-item-page.fxml"));
            Parent root = loader.load();

            AddItemPageController controller = loader.getController();
            controller.setStage(stage, category);


            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ModifyButtonClick(){
        Clothes selectedProduct = (Clothes) productListView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("modify-page.fxml"));
                Parent root = loader.load();

                ModifyController controller = loader.getController();
                controller.setStage(stage);
                controller.setSelectedProduct(selectedProduct);

                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public  void DelteButtonClick() throws SQLException {
        if(category.equals("Clothes")) {
            try {
                Clothes selectedClothe = (Clothes) productListView.getSelectionModel().getSelectedItem();
                DeleteOperations deleteOperations = new DeleteOperations();
                deleteOperations.DeleteClothes(selectedClothe.getNumber());
                listProducts();
            }catch (SQLException e) {
                showAlert(e.getMessage());
            }
        }

    }

}
