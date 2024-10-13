package org.example.womenstoreproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateOperation {
    public void insertIntoClothes(Clothes clothe) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql = "INSERT INTO Products (name, purchasePrice, sellPrice) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, clothe.getName());
            preparedStatement.setDouble(2, clothe.getPurchasePrice());
            preparedStatement.setDouble(3, clothe.getSellPrice());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    String sqlc = "INSERT INTO Clothes (number, size) VALUES (?, ?)";
                    try (PreparedStatement preparedStatement2 = connection.prepareStatement(sqlc)) {
                        preparedStatement2.setInt(1,generatedKeys.getInt(1) );
                        preparedStatement2.setInt(2, clothe.getSize());


                        preparedStatement2.executeUpdate();
                    }

                } else {
                    throw new SQLException("Échec de la création du produit, aucun ID généré.");
                }
            }
        }
    }



    public void insertIntoShoes(Shoes shoes) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql = "INSERT INTO Products (name, purchasePrice, sellPrice) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, shoes.getName());
            preparedStatement.setDouble(2, shoes.getPurchasePrice());
            preparedStatement.setDouble(3, shoes.getSellPrice());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    String sqlc = "INSERT INTO Shoes(number, size) VALUES (?, ?)";
                    try (PreparedStatement preparedStatement2 = connection.prepareStatement(sqlc)) {
                        preparedStatement2.setInt(1,generatedKeys.getInt(1) );
                        preparedStatement2.setInt(2, shoes.getShoeSize());


                        preparedStatement2.executeUpdate();
                    }

                } else {
                    throw new SQLException("Échec de la création du produit, aucun ID généré.");
                }
            }
        }
    }




}
