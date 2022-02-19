package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(10,20,30) {
        };
        Dimensions copy1 = new Dimensions(5,7,4) {

        };

        Cargo cargo = new Cargo(dimensions, 54,"новая деревня","складировать по 3","5468ad68", true);
        Cargo copy = new Cargo(copy1,12,"dfgh","dryt","3251",false);

        System.out.println(cargo);
        System.out.println("\n" + copy);
        System.out.println("\n" + cargo);

        }

    }

