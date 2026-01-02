package GameStory.Room;

import GameStory.Items.Item;
import GameStory.Terrains.Terrain;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<Terrain> terrains;
    private List<Item> items;
    private Room nextRoom;

    public Room(String name) {
        this.name = name;
        this.terrains = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public String getName() {
        return name;
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public List<Item> getItems() {
        return items;
    }
}
