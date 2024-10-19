package org.example.womenstoreproject;

public class Accessories extends Product{
    public Accessories(String name, double sellPrice, double purchasePrice) throws IllegalArgumentException {
        super(name, sellPrice, purchasePrice);
    }
    public Accessories(int number ,String name, double sellPrice, double purchasePrice,int numberOfItems){
        super(number,name,sellPrice,purchasePrice,numberOfItems);


    }
    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public  void  applyDiscount() {
        double price=this.getSellPrice()-this.getSellPrice()*50/100;
        this.setDiscountPrice(price);
    }
}
