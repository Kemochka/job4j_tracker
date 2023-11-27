package ru.job4j.oop;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("Mia");
        PizzaExtraCheese pizzaExtraCheese = new PizzaExtraCheese("Cheese");
        PizzaExtraCheeseExtraTomato pizzaExtraCheeseExtraTomato = new PizzaExtraCheeseExtraTomato("Margarita");
        System.out.println(pizza.name());
        System.out.println(pizzaExtraCheese.name());
        System.out.println(pizzaExtraCheeseExtraTomato.name());
    }
}
