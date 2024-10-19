package org.example.womenstoreproject;


import java.sql.SQLException;

public abstract class Product implements Discount,Comparable<Double> {

    private int number;
    private String name;
    private double purchasePrice;
    private double discountPrice;
    private double sellPrice;
    private int numberOfItems=0;
    private static  double capital=1000;
    private static double income=0;
    private static double cost=0;

    public Product(String name, double sellPrice, double purchasePrice) throws IllegalArgumentException {
        this. name =  name;
        this.sellPrice = sellPrice;
        this.purchasePrice = purchasePrice;
        this.number+=1;
        if(purchasePrice <0) throw  new IllegalArgumentException("purchase price cannot be negative");
        if(sellPrice<0) throw  new IllegalArgumentException("sell price cannot be negative");
    }
    public Product(int number,String name, double sellPrice, double purchasePrice, int numberOfItems){
        this. name =  name;
        this.sellPrice = sellPrice;
        this.purchasePrice = purchasePrice;
        this.number = number;
        this.numberOfItems = numberOfItems;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) throws IllegalArgumentException  {
        this.purchasePrice = purchasePrice;
        if(purchasePrice <0) throw  new IllegalArgumentException("price must not be negative");
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) throws IllegalArgumentException {
        this.discountPrice = discountPrice;
        if(discountPrice<0) throw  new IllegalArgumentException("price must not be negative");
    }

    public static double getCapital() {
        return capital;
    }

    public static void setCapital(double capital) {
        Product.capital = capital;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) throws IllegalArgumentException {
        this.sellPrice = sellPrice;
        if(sellPrice<0) throw new IllegalArgumentException("the price must be positive");
    }

    public static double getIncome() {
        return income;
    }

    public static void setIncome(double income) {
        Product.income = income;
    }

    public static double getCost() {
        return cost;
    }

    public static void setCost(double cost) {
        Product.cost = cost;
    }
    @Override
    public String toString() {
        return "number=" + number + ", name=" + name ;
    }
    public void sell(int nbItems) throws IllegalArgumentException, SQLException {
        double[] data =new SelectOperations().selectIncome();
        double income;
        double capital;

        if(this.numberOfItems==0) throw new IllegalArgumentException("this product is unavailable");

        else if(this.numberOfItems<nbItems) throw  new IllegalArgumentException("there is less product in stock than requested");

        else {
            this.numberOfItems-=nbItems;
        }

        if(this.discountPrice==0) {
            income=data[0]+this.sellPrice*nbItems;
            capital=data[2]+this.purchasePrice*nbItems;
        }
        else{
            income = data[0]+this.discountPrice*nbItems;
            capital = data[2]+this.discountPrice*nbItems;

        }
        new UpdateOperation().updateIncome(income,data[1],capital);

    }
    public void purchase(int nbItems) throws IllegalArgumentException, SQLException {
        double[] data =new SelectOperations().selectIncome();
        if(nbItems<0) throw new IllegalArgumentException("Number of items must not be negative");

        else if (data[2]<this.purchasePrice*nbItems) throw new IllegalArgumentException("Your Capital is insufficient to by this many items");
        this.numberOfItems+=nbItems;
        double cost=data[1]+this.purchasePrice*nbItems;
        double capital=data[2]-this.purchasePrice*nbItems;
        new UpdateOperation().updateIncome(data[0],cost,capital);


    }
    @Override
    public abstract void applyDiscount();
    @Override
    public int compareTo(Double o) {
        return Double.compare(this.sellPrice, o);
    }


}
