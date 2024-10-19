package org.example.womenstoreproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteOperations {
    public void DeleteClothes(int number) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql = "DELETE FROM Clothes WHERE number = ?";
        String sql2= "DELETE FROM Products WHERE number = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
            preparedStatement.setInt(1, number);
            preparedStatement2.setInt(1, number);

            int affectedRows = preparedStatement.executeUpdate();
            int affectedRows2 = preparedStatement2.executeUpdate();
            if (affectedRows == 0||affectedRows2 == 0) {
                connection.rollback();
                throw new SQLException("Échec de la suppression du vêtement, aucun enregistrement affecté.");

            }
        }

    }
    public void DeleteShoe(int number) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql = "DELETE FROM Shoes WHERE number = ?";
        String sql2= "DELETE FROM Products WHERE number = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
            preparedStatement.setInt(1, number);
            preparedStatement2.setInt(1, number);

            int affectedRows = preparedStatement.executeUpdate();
            int affectedRows2 = preparedStatement2.executeUpdate();
            if (affectedRows == 0||affectedRows2 == 0) {
                connection.rollback();
                throw new SQLException("Échec de la suppression du vêtement, aucun enregistrement affecté.");

            }
        }
    }
    public void DeleteAccessories(int number) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql = "DELETE FROM Accesories WHERE number = ?";
        String sql2= "DELETE FROM Products WHERE number = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
            preparedStatement.setInt(1, number);
            preparedStatement2.setInt(1, number);

            int affectedRows = preparedStatement.executeUpdate();
            int affectedRows2 = preparedStatement2.executeUpdate();
            if (affectedRows == 0||affectedRows2 == 0) {
                connection.rollback();
                throw new SQLException("Échec de la suppression du vêtement, aucun enregistrement affecté.");

            }
        }
    }

}
