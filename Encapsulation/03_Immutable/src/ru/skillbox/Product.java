package ru.skillbox;

public class Product {
    private final String name;
    private final int barCode;
    private int price;

    public Product(String name, int price, int barCode) {
        this.name = name;
        this.price = price;
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(){
        this.price = price;
    }
}
