package ru.job4j.collection;

import java.util.Comparator;

public class JobByPriority implements Comparator<Job> {
    @Override
    public int compare(Job right, Job left) {
        return Integer.compare(right.getPriority(), left.getPriority());
    }
}
