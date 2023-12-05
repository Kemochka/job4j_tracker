package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Едет");
    }

    @Override
    public void passengers(int x) {
        System.out.println("Пассаживы: " + x);
    }

    @Override
    public int refuel(int fuel, int price) {
        return fuel * price;
    }
}
