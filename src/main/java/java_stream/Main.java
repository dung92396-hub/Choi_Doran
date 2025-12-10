package java_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {


    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Triet hoc Mac Lenin", 400, 2016));
        books.add(new Book("Cau truc roi rac", 120, 2013));
        books.add(new Book("UX/UI", 200, 2023));
        books.add(new Book("Giai tich 1", 600, 2008));


        // stream sort
        System.out.println(books.stream().sorted(Comparator.comparingInt(Book::getPublishYear)).toList());
    }
}
