package HashTablePack;

import java.time.LocalDate;
import java.util.List;

public class Game {
    private String id;
    private String name;
    private String type;
    private LocalDate publishedYear;
    private List<String> tags;
    private double price;

    // Constructor
    public Game(String id, String name, String type, LocalDate publishedYear, List<String> tags, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.publishedYear = publishedYear;
        this.tags = tags;
        this.price = price;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(LocalDate publishedYear) {
        this.publishedYear = publishedYear;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "┌─────────────────────────────────┐\n" +
                "│         GAME INFORMATION        │\n" +
                "├─────────────────────────────────┤\n" +
                "│ ID              : " + String.format("%-15s", id) + " │\n" +
                "│ Name            : " + String.format("%-15s", name) + " │\n" +
                "│ Type            : " + String.format("%-15s", type) + " │\n" +
                "│ Published Year  : " + String.format("%-15s", publishedYear) + " │\n" +
                "│ Tags            : " + String.format("%-15s", tags) + " │\n" +
                "│ Price           : $" + String.format("%-14.2f", price) + " │\n" +
                "└─────────────────────────────────┘";
    }
}
