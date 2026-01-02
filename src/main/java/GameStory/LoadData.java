package GameStory;

import GameStory.Items.Item;
import GameStory.Items.TypeOfItem;
import GameStory.Room.Room;
import GameStory.Terrains.NormalTerrain;
import GameStory.Terrains.SpecialTerrain;
import GameStory.Terrains.Terrain;

public class LoadData {
    public static Scene LoadData() {
        Scene scene = new Scene();

        Room r1 = new Room("A01");
        Room r2 = new Room("A01");
        Room r3 = new Room("A01");

        Terrain t1 = new NormalTerrain("Giuong nam");
        Terrain t2 = new SpecialTerrain("Tu do");

        Item i1 = new Item(1L, "Chia khoa phong A01", TypeOfItem.KEY_ITEM);
        


        return null;
    }
}
