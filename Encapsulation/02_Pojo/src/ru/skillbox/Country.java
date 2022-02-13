package ru.skillbox;

public class Country {
    private String name;
    private int population;
    private double square;
    private String capital;
    private boolean seaAccess;

    public Country(String name) {
        this.name = name;
        this.population = population;
        this.square = square;



    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    public int getPopulation() {
        return population;
    }
    public void setSquare(double square) {
        this.square = square;
    }
    public double getSquare() {
        return square;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getCapital() {
        return capital;
    }
    public void setSeaAccess(boolean seaAccess) {
        this.seaAccess = seaAccess;
    }
    public boolean isSeaAccess() {
        return seaAccess;
    }
}
