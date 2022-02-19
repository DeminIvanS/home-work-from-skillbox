package ru.skillbox;

public class Cargo {
    private final int weight;
    private final String address;
    private final String property;

    private final String ID;
    private final boolean delicate;
    private Dimensions dimensions;


    public Cargo(Dimensions dimensions,
                 int weight,
                 String address,
                 String property,
                 String ID,
                 boolean delicate){
        this.dimensions = dimensions;
        this.weight = weight;
        this.address = address;
        this.property = property;
        this.ID = ID;
        this.delicate = delicate;
    }
    public int getWeight() {
        return weight;
    }
    public String getAddress() {
        return address;
    }

    public Cargo setWeight(int weight) {
        return new Cargo(dimensions, weight, address, property, ID,delicate);
    }
    public Cargo setAdress(String address) {
        return new Cargo(dimensions, weight, address, property, ID,delicate);
    }
    public Cargo setProperty(String property) {
        return new Cargo(dimensions, weight, address, property, ID,delicate);
    }
    public Cargo setID(String ID) {
        return new Cargo(dimensions, weight, address, property, ID,delicate);
    }
    public Cargo setDelicate(boolean delicate) {
        return new Cargo(dimensions, weight, address, property, ID,delicate);
    }

    public String toString(){

        return "объем " + dimensions.dimensions() + "куб.м" +
                "\nвес груза: " + weight + "кг" +
                "\nАдрес доставки: " + address +
                "\nсвойства груза: " + property +
                "\nрегистрационный номер: " + ID +
                "\nхрупкость:" + delicate;
    }

}

