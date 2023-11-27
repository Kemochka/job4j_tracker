package ru.job4j.oop;

import ru.job4j.tracker.Item;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdFormat = formatter.format(item.getCreated());
        System.out.println(createdFormat);
    }
}
