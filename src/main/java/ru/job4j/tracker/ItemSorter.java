package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(1, "Kris"),
                new Item(2, "Victor"),
                new Item(3, "Natali")
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "Kris"),
                new Item(2, "Victor"),
                new Item(3, "Natali")
        );

        System.out.println(items);
        Collections.sort(expected, new ItemDescByName());
        System.out.println(expected);
        System.out.println();
        System.out.println(items);
        Collections.sort(expected, new ItemAscByName());
        System.out.println(expected);
    }
}
