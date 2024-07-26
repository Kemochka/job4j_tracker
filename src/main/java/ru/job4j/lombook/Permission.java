package ru.job4j.lombook;

import lombok.*;

import java.util.List;

@Builder(builderMethodName = "of")
@Data
public class Permission {
    private int id;
    private String name;
    @Singular("accessBy")
    private List<String> rules;
}
