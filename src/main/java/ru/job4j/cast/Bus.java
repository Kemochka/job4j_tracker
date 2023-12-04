package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - ездит по маршрутам, развозит пассажиров.");
    }
}
