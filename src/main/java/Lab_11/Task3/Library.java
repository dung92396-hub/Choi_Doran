package Lab_11.Task3;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public Book getOldestBook() {
        return books
                .stream()
                .min(Comparator.comparing(Book::getOld))
                .orElseThrow();
    }

    public Map<Integer, List<Book>> getBooksByYear() {
        return books
                .stream()
                .collect(Collectors.groupingBy(Book::getYear));
    }

    public Set<Book> findBooks(String authorName, int year) {
        return books
                .stream()
                .filter(book -> book.getAuthors()
                        .stream()
                        .anyMatch(author -> author.getName().equals(authorName)) &&
                        book.getYear() == year)
                .collect(Collectors.toSet());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
