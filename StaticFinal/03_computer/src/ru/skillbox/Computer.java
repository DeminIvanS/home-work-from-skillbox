package ru.skillbox;

public class Computer {

    private final String vendor;
    private final String name;
    private CPU cpu;
    private ROM rom;
    private RAM ram;
    private Display display;
    private Keyboard keyboard;



    public Computer(String vendor, String name, CPU cpu,
                    ROM rom,
                    RAM ram,
                    Display display,
                    Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.rom = rom;
        this.ram = ram;
        this.display = display;
        this.keyboard = keyboard;

    }

    public void setCPU(CPU cpu) {
        this.cpu = cpu;
    }
    public void setROM(ROM rom) {
        this.rom = rom;
    }
    public void setRAM(RAM ram) {
        this.ram = ram;
    }
    public void setDisplay(Display display) {
        this.display = display;
    }
    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public CPU getCPU() {
        return cpu;
    }
    public ROM getROM() {
        return rom;
    }
    public RAM getRAM() {
        return ram;
    }
    public Display getDisplay() {
        return display;
    }
    public Keyboard getKeyboard() {
        return keyboard;
    }


    public int getTotalWeight(){
        return cpu.weightCPU +
                ram.weightRAM +
                rom.weightROM +
                display.weightDisplay +
                keyboard.weightKeyboard;

    }


    public String toString(){
        return "Производитель: " + vendor + "\nНазвание: " + name +
                "\nСведения о роцессоре: " + cpu +
                "\nСведения о ОЗУ: " + ram +
                "\nСведения о ПЗУ: " + rom +
                "\nСведения о мониторе: " + display +
                "\nСведения о клавиатуре: " + keyboard +
                "\nОбщий комплектующих: " + getTotalWeight() + "г";
    }


}
