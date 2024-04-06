package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.MemTracker;

public interface User {
    String name();

    boolean execute(Input input, Store tracker);
}
