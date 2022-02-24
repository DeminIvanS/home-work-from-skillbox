package ru.skillbox;

public class Display {
    private final TypeDisplay type;
    private final int diagonal;
    public int weightDisplay;// в граммах

    public Display(TypeDisplay type, int diagonal, int weight) {
        this.type = type;
        this.diagonal = diagonal;
        this.weightDisplay = weight;
    }

    public TypeDisplay getType() {
        return type;
    }
    public int getDiagonal() {
        return diagonal;
    }
    public int getWeightDisplay() {
        return weightDisplay;
    }

    public Display setType(TypeDisplay type) {
        return new Display(type, diagonal, weightDisplay);
    }
    public Display setVolume(int diagonal) { return new Display(type, diagonal, weightDisplay); }
    public Display setWidthDisplay(int weightDisplay) {
        return new Display(type, diagonal, weightDisplay);
    }

    public String toString() {
        return "\nТип матрицы: " + type +
                "\nДиагональ: " + diagonal + "\"" +
                "\nВес: " + weightDisplay + "г";

    }
}
