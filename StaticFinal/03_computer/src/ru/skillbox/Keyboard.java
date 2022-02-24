package ru.skillbox;

public class Keyboard {
    private final TypeKeyboard type;
    private final BacklightKeyboard backlight;
    public int weightKeyboard;// в граммах

    public Keyboard(TypeKeyboard type, BacklightKeyboard backlight, int weight) {
        this.type = type;
        this.backlight = backlight;
        this.weightKeyboard = weight;
    }
    public TypeKeyboard getType() {
        return type;
    }
    public BacklightKeyboard getBacklight() {
        return backlight;
    }
    public int getWeightKeyboard() {
        return weightKeyboard;
    }

    public Keyboard setType(TypeKeyboard type) { return new Keyboard(type, backlight, weightKeyboard); }
    public Keyboard setVolume(BacklightKeyboard backlight) {
        return new Keyboard(type, backlight, weightKeyboard);
    }
    public Keyboard setWidthKeyboard(int weightKeyboard) {
        return new Keyboard(type, backlight, weightKeyboard);
    }

    public String toString() {
        return "\nТип клавиатуры: " + type +
                "\nПодсветка клавиш: " + backlight +
                "\nВес: " + weightKeyboard + "г";

    }
}
