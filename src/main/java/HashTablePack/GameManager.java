package HashTablePack;

import java.util.List;

public class GameManager {
    private String name;
    private List<Game> games;
    private List<User> users;

    // Constructor
    public GameManager(String name, List<Game> games, List<User> users) {
        this.name = name;
        this.games = games;
        this.users = users;
    }

    public GameManager(String name) {
        this.name = name;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "┌────────────────────────────────────────┐\n" +
                "│     GAME MANAGER INFORMATION           │\n" +
                "├────────────────────────────────────────┤\n" +
                "│ Manager Name     : " + String.format("%-19s", name) + " │\n" +
                "│ Total Games      : " + String.format("%-19d", (games != null ? games.size() : 0)) + " │\n" +
                "│ Total Users      : " + String.format("%-19d", (users != null ? users.size() : 0)) + " │\n" +
                "└────────────────────────────────────────┘";
    }
}
