package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Kristina");
        student.setGroup(421);
        student.setEntrance(new Date());

        System.out.println(student.getName() + " Group " + student.getGroup()  + ", date of admission " + student.getEntrance());
    }
}
