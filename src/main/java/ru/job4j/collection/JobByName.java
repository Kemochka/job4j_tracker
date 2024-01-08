package ru.job4j.collection;

import java.util.Comparator;

public class JobByName implements Comparator<Job> {
    @Override
    public int compare(Job right, Job left) {
        return right.getName().compareTo(left.getName());
    }
}
