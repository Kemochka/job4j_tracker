package ru.job4j.oop;

public class HtmlReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return "<h1>" + name + "</h1>"
                + "<br/>"
                + "<span>" + body + "</span>";
    }

    public static void main(String[] args) {
        HtmlReport html = new HtmlReport();
        String text1 = html.generate("name", "body");
        System.out.println(text1);
    }
}
