package ru.job4j.cast;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - ездит по рельсам от станции до станции.");
    }
}
