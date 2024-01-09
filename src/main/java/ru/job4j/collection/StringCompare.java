package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = Math.min(left.length(), right.length());
        for (int i = 0; i < length; i++) {
            char l = left.charAt(i);
            char r = right.charAt(i);
            result = Character.compare(l, r);
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }

}

