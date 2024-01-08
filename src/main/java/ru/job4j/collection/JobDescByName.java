package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job right, Job left) {
        return left.getName().compareTo(right.getName());
    }
}
