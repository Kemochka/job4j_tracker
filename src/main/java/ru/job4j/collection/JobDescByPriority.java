package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
    @Override
    public int compare(Job right, Job left) {
        return Integer.compare(left.getPriority(), right.getPriority());
    }
}
