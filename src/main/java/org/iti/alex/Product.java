package org.iti.alex;

public class Product {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void increasePrice(double increaseValue){
        price += increaseValue;
    }

    public String getCode() {
        if(price > 1000){
            return  "RED1200";
        }
         return  "Primary";
    }
}
