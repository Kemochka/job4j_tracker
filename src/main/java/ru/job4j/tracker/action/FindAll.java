package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

public class FindAll implements User {
    private final Output out;

    public FindAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {

        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}