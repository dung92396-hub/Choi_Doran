package Lab_11.Task2;

import java.sql.Ref;
import java.util.*;
import java.util.stream.Collectors;

public class BookManager {
    private final List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }

    // may phuong thuc tu 1 toi 5 don gian mot code sau gio luoi qua

    public int totalOfBookPrice() {
        return books
                .stream()
                .map(Book::getPrice)
                .reduce(0, Integer::sum);
    }

    public ReferenceBook maxActPageNumber() {
        return (ReferenceBook) books
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
