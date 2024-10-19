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
        disableSizeTxt(category);
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
    private void disableSizeTxt(String category){
        if (category.equals("Accesories")){
            txtsize.setVisible(false);
        }
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



    public void listProducts() throws SQLException {
        if (category != null) {
            if (category.equals("Clothes")) {
                productListView.setItems(SelectOperations.selectClothes());
                productListView.setOnMouseClicked(this::clothesClick);
            } else if (category.equals("Shoes")) {
                productListView.setItems(SelectOperations.selectShoes());
                productListView.setOnMouseClicked(this::shoesClick);
            } else if (category.equals("Accesories")) {
                productListView.setItems(SelectOperations.selectAccessoiries());
                productListView.setOnMouseClicked(this::accessoriesClick);

            }
        }
    }

    private void clothesClick(MouseEvent event) {
        Clothes selectedClothe = (Clothes) productListView.getSelectionModel().getSelectedItem();
        if (selectedClothe != null) {

            txtname.setText(selectedClothe.getName());
            txtpurchaseprice.setText(String.valueOf(selectedClothe.getPurchasePrice()));
            txtsellprice.setText(String.valueOf(selectedClothe.getSellPrice()));
            txtsize.setText(String.valueOf(selectedClothe.getSize()));
            txtstock.setText(String.valueOf(selectedClothe.getNumberOfItems()));
            if(selectedClothe.getDiscountPrice()==0.0) {
                txtdiscounted.setText("This Product is not discounted");
            }
            else {
                txtdiscounted.setText(String.valueOf(selectedClothe.getDiscountPrice()));
            }
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
            if(selectedShoe.getDiscountPrice()==0) {
                txtdiscounted.setText("This Product is not discounted");
            }
            else {
                txtdiscounted.setText(String.valueOf(selectedShoe.getDiscountPrice()));
            }
        }
    }

    private void accessoriesClick(MouseEvent event) {
        Accessories selectedAccessorie = (Accessories) productListView.getSelectionModel().getSelectedItem();
        if (selectedAccessorie != null) {

            txtname.setText(selectedAccessorie.getName());
            txtpurchaseprice.setText(String.valueOf(selectedAccessorie.getPurchasePrice()));
            txtsellprice.setText(String.valueOf(selectedAccessorie.getSellPrice()));

            txtstock.setText(String.valueOf(selectedAccessorie.getNumberOfItems()));
            if(selectedAccessorie.getDiscountPrice()==0) {
                txtdiscounted.setText("This Product is not discounted");
            }
            else {
                txtdiscounted.setText(String.valueOf(selectedAccessorie.getDiscountPrice()));
            }
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
        Product selectedProduct = productListView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("modify-page.fxml"));
                Parent root = loader.load();

                ModifyController controller = loader.getController();
                controller.setStage(stage,this.category);
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
        } else if (category.equals("Shoes")) {
            try {
                Shoes selectedShoe = (Shoes) productListView.getSelectionModel().getSelectedItem();
                DeleteOperations deleteOperations = new DeleteOperations();
                deleteOperations.DeleteShoe(selectedShoe.getNumber());
                listProducts();
            }catch (SQLException e) {
                showAlert(e.getMessage());
            }

        }
        else if (category.equals("Accesories")) {
            try {
                Accessories selectedAccessorie = (Accessories) productListView.getSelectionModel().getSelectedItem();
                DeleteOperations deleteOperations = new DeleteOperations();
                deleteOperations.DeleteAccessories(selectedAccessorie.getNumber());
                listProducts();
            }catch (SQLException e) {
                showAlert(e.getMessage());
            }

        }

    }

    private void returnButtonClick(Stage stage){
        MainViewController mainViewController = new MainViewController();
        mainViewController.setStage(stage);
        mainViewController.handleButtonClick();
    }
    @FXML
    public void returnButtonClick(){
      returnButtonClick(stage);
    }
    public void purchaseButtonClick(){
        Product selectedProduct = productListView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("quantity-page.fxml"));
                Parent root = loader.load();

                QuantityPageController controller = loader.getController();
                controller.setStage(stage,this.category,"purchase");
                controller.sellProduct(selectedProduct);

                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void applyDiscountButtonClick() throws SQLException {
        Product selectedProduct = productListView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            if(this.category.equals("Clothes")) {
                new UpdateOperation().applyDiscountClothe((Clothes) selectedProduct);
            }
            else if(this.category.equals("Shoes")) {

                new UpdateOperation().applyDiscountShoe((Shoes) selectedProduct);
            } else if (this.category.equals("Accesories")) {

                new UpdateOperation().applyDiscountAccessories((Accessories) selectedProduct);
            }
        }
    }
    public void sellProductButtonClick(){
        Product selectedProduct = productListView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("quantity-page.fxml"));
                Parent root = loader.load();

                QuantityPageController controller = loader.getController();
                controller.setStage(stage,this.category,"sell");
                controller.sellProduct(selectedProduct);

                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
