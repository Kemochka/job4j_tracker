package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return Calculator.sum(d) + Calculator.minus(d) + multiply(d) + divide(d);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int result1 = minus(15);
        System.out.println(result1);
        Calculator calc = new Calculator();
        int rsl1 = calc.divide(25);
        System.out.println(rsl1);
        Calculator calc1 = new Calculator();
        int rsl2 = calc1.sumAllOperation(15);
        System.out.println(rsl2);
    }
}
