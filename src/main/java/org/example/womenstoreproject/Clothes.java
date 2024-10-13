package org.example.womenstoreproject;



public class Clothes extends Product {
    private int size;
    public Clothes(String name, double sellPrice, double purchasePrice, int size) throws IllegalArgumentException {
        super(name, sellPrice, purchasePrice);
        this.size = size;
        if(size<34 || size>54) throw new IllegalArgumentException("size must be between 34 and 54");
    }
   public Clothes(int number ,String name, double sellPrice, double purchasePrice,int numberOfItems,int size){
       super(number,name,sellPrice,purchasePrice,numberOfItems);
        this.size = size;

   }
    public int getSize() {
        return size;
    }

    public void setSize(int size) throws IllegalArgumentException {
        this.size = size;
        if(size<34 || size>54) throw new IllegalArgumentException("size must be between 34 and 54");
    }
    @Override
    public String toString() {
        return super.toString()+" size=" + size ;
    }
    @Override
    public void applyDiscount() {
        double price=this.getSellPrice()*30/100;
        this.setDiscountPrice(price);
    }

}
