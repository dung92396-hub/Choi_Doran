package Lab_11.Task3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String id;
    private String title;
    private int price;
    private String type;
    private int year;
    private List<Author> authors;

    public Book(String id, String title, int price, String type, int year) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.type = type;
        this.year = year;
        authors = new ArrayList<>();
    }

    public boolean containsAuthorAndYear(String authorName, int year) {
        return authors
                .stream()
                .anyMatch(author -> author.getName().equals(authorName)) &&
                this.year == year;
    }

    public int getOld() {
        return LocalDate.now().getYear() - year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
