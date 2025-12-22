package HashTablePack;

import java.util.List;

public class User {
    private String id;
    private String name;
    private List<Game> storage;

    // Constructor
    public User(String id, String name, List<Game> storage) {
        this.id = id;
        this.name = name;
        this.storage = storage;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Game> getStorage() {
        return storage;
    }

    public void setStorage(List<Game> storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "┌──────────────────────────────────────┐\n" +
                "│        USER INFORMATION             │\n" +
                "├──────────────────────────────────────┤\n" +
                "│ ID               : " + String.format("%-18s", id) + " │\n" +
                "│ Name             : " + String.format("%-18s", name) + " │\n" +
                "│ Storage (Games)  : " + (storage != null ? storage.size() : 0) + " game(s)                  │\n" +
                "└──────────────────────────────────────┘";
    }
}
