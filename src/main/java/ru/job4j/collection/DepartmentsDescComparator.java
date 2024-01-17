package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int comp = right.split("/")[0].compareTo(left.split("/")[0]);
        return comp != 0 ? comp : left.compareTo(right);
    }
}
