package ru.job4j.lombook;

public class LombokUsage {
    public static void main(String[] args) {
        var rule = Permission.of()
                .id(1)
                .name("Name")
                .accessBy("create")
                .accessBy("update")
                .accessBy("delete")
                .build();
        System.out.println(rule);
    }
}
