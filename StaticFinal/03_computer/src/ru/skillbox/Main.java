package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        CPU cpu = new CPU(MakeCPU.INTEL, 2133,12,45);
        RAM ram = new RAM(TypeRAM.DDR4, 16, 20);
        ROM rom = new ROM(TypeROM.SSD, 256,30);
        Display display = new Display(TypeDisplay.VA,24,3320);
        Keyboard keyboard = new Keyboard(TypeKeyboard.MECHANICAL,BacklightKeyboard.YES,800);

        CPU cpu2 = new CPU(MakeCPU.ELBRUS, 1800,2,50);
        RAM ram2 = new RAM(TypeRAM.DDR3, 4, 135);
        ROM rom2 = new ROM(TypeROM.HDD, 512,1300);
        Display display2 = new Display(TypeDisplay.IPS,22,2320);
        Keyboard keyboard2 = new Keyboard(TypeKeyboard.MEMBRAN,BacklightKeyboard.NO,700);

        Computer computer = new Computer("Irbis", "Gametower", cpu, rom, ram,display,keyboard) {
        };
        Computer computer2 = new Computer("ACER", "Aspire", cpu2, rom2, ram2, display2, keyboard2) {

        };
        System.out.println(computer);
        System.out.println("\n" + computer2);

    }
}
