package org.example.womenstoreproject;
import java.sql.*;

public class UpdateOperation {
    public void updateClothes(Clothes clothe) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET name=?,sellPrice=?,purchasePrice=? WHERE number=? ";
        String sql2="UPDATE Clothes SET size=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement.setString(1, clothe.getName());
        preparedStatement.setDouble(2, clothe.getSellPrice());
        preparedStatement.setDouble(3, clothe.getPurchasePrice());
        preparedStatement.setInt(4, clothe.getNumber());
        preparedStatement2.setInt(1,clothe.getSize());
        preparedStatement2.setInt(2,clothe.getNumber());
        preparedStatement2.executeUpdate();
        preparedStatement.executeUpdate();
    }

    public  void updateShoes(Shoes shoes) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET name=?,sellPrice=?,purchasePrice=? WHERE number=? ";
        String sql2="UPDATE Shoes SET size=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement.setString(1, shoes.getName());
        preparedStatement.setDouble(2, shoes.getSellPrice());

        preparedStatement.setDouble(3, shoes.getPurchasePrice());
        preparedStatement.setInt(4, shoes.getNumber());
        preparedStatement2.setInt(1,shoes.getShoeSize());
        preparedStatement2.setInt(2,shoes.getNumber());
        preparedStatement2.executeUpdate();
        preparedStatement.executeUpdate();
    }

    public void updateAccessories(Accessories accessorie) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET name=?,sellPrice=?,purchasePrice=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, accessorie.getName());
        preparedStatement.setDouble(2, accessorie.getSellPrice());
        preparedStatement.setDouble(3, accessorie.getPurchasePrice());
        preparedStatement.setInt(4, accessorie.getNumber());
        preparedStatement.executeUpdate();
    }


    //PURCHASE AND SELL OPERATIONS
    public void purchaseProduct(Product product,int number) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET numberOfItems=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        product.purchase(number);
        preparedStatement.setInt(1, product.getNumberOfItems());
        preparedStatement.setInt(2, product.getNumber());
        preparedStatement.executeUpdate();
    }
    public void sellProduct(Product product,int number) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET numberOfItems=? WHERE number=? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        product.sell(number);
        preparedStatement.setInt(1, product.getNumberOfItems());
        preparedStatement.setInt(2, product.getNumber());
        preparedStatement.executeUpdate();
    }

    public void updateIncome(double income,double cost,double capital) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Income SET income=?, cost=? , capital=? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setDouble(1, income);
        preparedStatement.setDouble(2, cost);
        preparedStatement.setDouble(3, capital);

        preparedStatement.executeUpdate();
    }
    //Discount Operations
    public void applyDiscountClothe(Clothes clothe) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET discountPrice=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        clothe.applyDiscount();
        preparedStatement.setDouble(1 ,clothe.getDiscountPrice());
        preparedStatement.setInt(2, clothe.getNumber());
        preparedStatement.executeUpdate();
    }
    public void applyDiscountShoe(Shoes shoes) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET discountPrice=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        shoes.applyDiscount();
        preparedStatement.setDouble(1 ,shoes.getDiscountPrice());
        preparedStatement.setInt(2, shoes.getNumber());
        preparedStatement.executeUpdate();
    }
    public void applyDiscountAccessories(Accessories accessories) throws SQLException {
        Connection connection = Databaseconnection.getConnection();
        String sql="UPDATE Products SET discountPrice=? WHERE number=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        accessories.applyDiscount();
        preparedStatement.setDouble(1 ,accessories.getDiscountPrice());
        preparedStatement.setInt(2, accessories.getNumber());
        preparedStatement.executeUpdate();
    }

}

