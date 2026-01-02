package GameStory;

import GameStory.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Item> storage;

    public Player() {
        this.storage = new ArrayList<>();
    }



    public List<Item> getStorage() {
        return storage;
    }
}
