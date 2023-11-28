package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Clean Code", 24);
        Book book1 = new Book("Naruto", 345);
        Book book2 = new Book("Creed", 67);
        Book boor3 = new Book("Rain", 12);
        Book[] books = new Book[4];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = boor3;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println("Swap books with index 0 and 3");
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println("Output of books named Clean code");
        for (Book bk : books) {
            if ("Clean Code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getPages());
            }
        }
    }
}
