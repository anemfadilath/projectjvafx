package org.example.womenstoreproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectOperations {
    public static ObservableList<Product> selectClothes() throws SQLException {
        ObservableList<Product> clothes = FXCollections.observableArrayList();
        Connection connection = Databaseconnection.getConnection();
        String query = "SELECT Products.number, Products.name, Products.sellPrice, Products.purchasePrice, Products.numberOfItems, Clothes.size FROM Products JOIN Clothes ON Products.number = Clothes.number";

        Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int number = resultSet.getInt("number");
                String name = resultSet.getString("name");
                double sellPrice = resultSet.getDouble("sellPrice");
                double purchasePrice = resultSet.getDouble("purchasePrice");
                int size= resultSet.getInt("size");
                int numberOfItems = resultSet.getInt("numberOfItems");
                clothes.add(new Clothes( number,name, sellPrice, purchasePrice,numberOfItems,size));
            }

        return clothes;
    }


    public static ObservableList<Product> selectShoes() throws SQLException {
        ObservableList<Product> shoes = FXCollections.observableArrayList();
        Connection connection = Databaseconnection.getConnection();
        String query = "SELECT Products.number, Products.name, Products.sellPrice, Products.purchasePrice, Products.numberOfItems, Shoes.size FROM Products JOIN Shoes ON Products.number = Shoes.number";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int number = resultSet.getInt("number");
            String name = resultSet.getString("name");
            double sellPrice = resultSet.getDouble("sellPrice");
            double purchasePrice = resultSet.getDouble("purchasePrice");
            int size= resultSet.getInt("size");
            int numberOfItems = resultSet.getInt("numberOfItems");
            shoes.add(new Shoes( number,name, sellPrice, purchasePrice,numberOfItems,size));
        }

        return shoes;
    }
}
