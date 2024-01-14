package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (key, value) -> map.put(key, map.get(key));
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        System.out.println(map);

        BiPredicate<Integer, String> biPredicate = (key, value) -> map.containsKey(map.get(key));
        for (Integer key : map.keySet()) {
            if (key % 2 == 0 || map.get(key).length() == 4) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }
            Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
            Consumer<String> consumer = (string) -> System.out.println(string);
            consumer.accept(String.valueOf(supplier.get()));
            Function<String, String> function = string -> string.toUpperCase();
        for (String string : map.values()) {
            System.out.println(string.toUpperCase());
        }
    }
}

