package org.example.womenstoreproject;

public class Shoes extends Product{
    private int shoeSize;
    public Shoes(String name, double sellPrice, double purchasePrice, int shoeSize) throws IllegalArgumentException {
        super(name, sellPrice, purchasePrice);
        this.shoeSize = shoeSize;
        if(shoeSize < 36||shoeSize > 50) throw new IllegalArgumentException("the shoe size must be between 36 and 50");
    }
    public Shoes(int number ,String name, double sellPrice, double purchasePrice,int numberOfItems,int shoeSize){
        super(number,name,sellPrice,purchasePrice,numberOfItems);
        this.shoeSize = shoeSize;

    }
    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) throws IllegalArgumentException {
        this.shoeSize = shoeSize;
        if(shoeSize < 36||shoeSize > 50) throw new IllegalArgumentException("the shoe size must be between 36 and 50");
    }
    @Override
    public String toString() {
        return super.toString() + "Shoes [shoeSize=" + shoeSize + "]";
    }
    @Override
    public void applyDiscount() {
        double price=this.getSellPrice()*20/100;
        this.setDiscountPrice(price);
    }
}
