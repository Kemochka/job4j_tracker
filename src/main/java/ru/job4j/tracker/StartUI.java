package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    Item item = new Item();

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdFormat = formatter.format(item.getCreated());
        System.out.println(createdFormat);
        Item item1 = new Item();
        System.out.println(item1);
    }

    @Override
    public String toString() {
        return "StartUI{"
                + "item=" + item
                + '}';
    }
}
