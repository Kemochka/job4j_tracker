package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Item> items = Arrays.asList(
                new Item(1, "Kris", LocalDateTime.parse("2024-04-06 23:34:33", formatter)),
                new Item(2, "Victor", LocalDateTime.parse("2024-04-06 23:34:33", formatter)),
                new Item(3, "Natali", LocalDateTime.parse("2024-04-06 23:34:33", formatter))
        );
        System.out.println(items);
        items.sort(new ItemAscByName());
        System.out.println(items);
        System.out.println();
        System.out.println(items);
        items.sort(new ItemDescByName());
        System.out.println(items);
    }
}
