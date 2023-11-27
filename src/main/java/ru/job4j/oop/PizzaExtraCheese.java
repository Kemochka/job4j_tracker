package ru.job4j.oop;

public class PizzaExtraCheese extends Pizza {
    private static final String CHEESE = " + extra cheese";

    public PizzaExtraCheese(String name) {
        super(name);
    }

    public String name() {
        return super.name() + CHEESE;
    }
}
