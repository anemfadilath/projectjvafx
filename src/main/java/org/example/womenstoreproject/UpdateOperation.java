package org.example.womenstoreproject;
import java.sql.*;

public class UpdateOperation {
    public void updateClothes(Clothes clothe) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET name=?,sellPrice=? WHERE number=? ";
        String sql2="UPDATE Clothes SET size=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement.setString(1, clothe.getName());
        preparedStatement.setDouble(2, clothe.getSellPrice());
        preparedStatement.setInt(3, clothe.getNumber());
        preparedStatement2.setInt(1,clothe.getSize());
        preparedStatement2.setInt(2,clothe.getNumber());
        preparedStatement2.executeUpdate();
        preparedStatement.executeUpdate();
    }

    public  void updateShoes(Shoes shoes) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET name=?,sellPrice=? WHERE number=? ";
        String sql2="UPDATE Shoes SET size=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement.setString(1, shoes.getName());
        preparedStatement.setDouble(2, shoes.getSellPrice());
        preparedStatement.setInt(3, shoes.getNumber());
        preparedStatement2.setInt(1,shoes.getShoeSize());
        preparedStatement2.setInt(2,shoes.getNumber());
        preparedStatement2.executeUpdate();
        preparedStatement.executeUpdate();
    }

    public void updateAccessories(Accessories accessorie) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET name=?,sellPrice=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, accessorie.getName());
        preparedStatement.setDouble(2, accessorie.getSellPrice());
        preparedStatement.setInt(3, accessorie.getNumber());
        preparedStatement.executeUpdate();
    }


    //PURCHASE OPERATIONS
    public void purchaseProduct(Product product,int number) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET numberOfItems=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        product.purchase(number);
        preparedStatement.setInt(1, product.getNumberOfItems());
        preparedStatement.setInt(2, product.getNumber());
        preparedStatement.executeUpdate();
    }

}

