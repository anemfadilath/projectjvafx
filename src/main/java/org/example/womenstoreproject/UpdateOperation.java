package org.example.womenstoreproject;
import java.sql.*;

public class UpdateOperation {
    public void updateClothes(Clothes clothe) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET name=?,sellPrice=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, clothe.getName());
        preparedStatement.setDouble(2, clothe.getSellPrice());
        preparedStatement.setInt(3, clothe.getNumber());
        preparedStatement.executeUpdate();
    }
}
