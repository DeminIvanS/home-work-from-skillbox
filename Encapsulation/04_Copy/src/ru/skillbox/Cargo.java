package ru.skillbox;

public class Cargo {
    private final int volume;
    private final int weight;
    private final String address;
    private final String property;
    private final String ID;
    private final boolean delicate;

    public Cargo(int volume, int weight, String address, String property, String ID, boolean delicate){
        this.volume = volume;
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

    public String toString(){

        return "объем " + volume + "куб.м" +
                "\nвес груза: " + weight + "кг" +
                "\nАдрес доставки: " + address +
                "\nсвойства груза: " + property +
                "\nрегистрационный номер: " + ID +
                "\nхрупкость:" + delicate;
    }
}

