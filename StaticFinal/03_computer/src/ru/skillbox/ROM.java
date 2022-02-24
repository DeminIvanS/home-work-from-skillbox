package ru.skillbox;

public class ROM {
    private final TypeROM type;
    private final int volume;
    public int weightROM; // в граммах

    public ROM(TypeROM type, int volume, int weight) {
        this.type = type;
        this.volume = volume;
        this.weightROM = weight;
    }
    public TypeROM getType() {
        return type;
    }
    public int getVolume() {
        return volume;
    }
    public int getWeightROM() {
        return weightROM;
    }

    public ROM setType(TypeROM type) {
        return new ROM(type, volume, weightROM);
    }
    public ROM setVolume(int volume) {
        return new ROM(type, volume, weightROM);
    }
    public ROM setWidthROM(int weightROM) {
        return new ROM(type, volume, weightROM);
    }
    public String toString() {
        return "\nТип накопителя: " + type +
                "\nОбъем: " + volume + "Gb" +
                "\nВес: " + weightROM + "г";
    }
}
