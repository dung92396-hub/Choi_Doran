package Lab_11.Task2;

import java.sql.Ref;
import java.util.*;
import java.util.stream.Collectors;

public class BookManager {
    private final List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    public int totalOfBookPrice() {
        return books
                .stream()
                .map(Book::getPrice)
                .reduce(0, Integer::sum);
    }

    public Book maxActPageNumber() {
        return books
                .stream()
                .filter(b -> b instanceof ReferenceBook)
                .max(Comparator.comparingInt(r -> ((ReferenceBook) r).maxActPageNumber()))
                .orElseThrow();
    }

    public boolean containsMagazine(String name) {
        return books
                .stream()
                .filter(b -> b instanceof Magazine)
                .anyMatch(m -> ((Magazine) m).getMagazineName().equals(name));
    }

    public List<Book> getPublishedBookByYear(int year) {
        return books
                .stream()
                .filter(b -> Objects.equals(b.getPublishedYear(), year))
                .toList();
    }

    public TreeSet<Book> sortBookByTitleAndYear() {
        return books
                .stream()
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(Comparator.comparing(Book::getTitle).thenComparingInt(Book::getPublishedYear).reversed())
                ));
    }

    public List<Book> getBooks() {
        return books;
    }
}
