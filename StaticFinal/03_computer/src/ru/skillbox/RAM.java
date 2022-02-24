package ru.skillbox;

public class RAM {
    private final TypeRAM type;
    private final int volume;
    public int weightRAM; //в граммах


    public RAM(TypeRAM type, int volume, int weight) {
        this.type = type;
        this.volume = volume;
        this.weightRAM = weight;
    }

    public TypeRAM getType() {
        return type;
    }
    public int getVolume() {
        return volume;
    }
    public int getWeightRAM() {
        return weightRAM;
    }


    public RAM setType(TypeRAM type) {
        return new RAM(type, volume, weightRAM);
    }
    public RAM setVolume(int volume) {
        return new RAM(type, volume, weightRAM);
    }
    public RAM setWidthRAM(int weightRAM) {
        return new RAM(type, volume, weightRAM);
    }

    public String toString() {
        return "\nТип памяти: " + type +
                "\nОбъем: " + volume + "Gb" +
                "\nВес: " + weightRAM + "г";
    }
}
