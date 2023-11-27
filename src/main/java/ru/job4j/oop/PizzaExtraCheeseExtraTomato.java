package ru.job4j.oop;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final String TOMATO = " + extra tomato";

    public PizzaExtraCheeseExtraTomato(String name) {
        super(name);
    }

    public String name() {
        return super.name() + TOMATO;
    }
}
