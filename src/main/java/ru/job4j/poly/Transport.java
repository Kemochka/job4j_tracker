package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers();

    default int refuel(int fuel, int price) {
        return 0;
    }
}
