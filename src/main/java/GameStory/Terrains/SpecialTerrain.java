package GameStory.Terrains;

import GameStory.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class SpecialTerrain extends Terrain {
    private List<Item> items;

    public SpecialTerrain(String name) {
        super(name);
        this.items = new ArrayList<>();
    }

}
