package org.example.womenstoreproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class QuantityPageController {
    private String category;
    private Stage stage;
    private Product product;

    public void setStage(Stage stage,String category) {
        this.stage = stage;
        this.category = category;
        System.out.println(category);

    }

    @FXML
    private TextField txtquantity;
    public void purchaseProduct(Product product)  {

           this.product =product;

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
    @FXML
    void handleCancel(ActionEvent event) {

    }

    @FXML
    public void ConfirmButtonClick() throws SQLException {
        new UpdateOperation().purchaseProduct(this.product, Integer.parseInt(txtquantity.getText()));
    returnToPage(this.category);
    }

}