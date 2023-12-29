package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("kemaevak@yandex.ru", "Kemaeva Kristina Igorevna");
        map.put("kemaevak@yandex.ru", "Kemaeva Kristina Igorevna");
        map.put("kkemaeva@list.ru", "Kris");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
