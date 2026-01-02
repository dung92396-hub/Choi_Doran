package GameStory.Items;

public class Item {
    private Long itemId;
    private String itemName;
    private TypeOfItem typeOfItem;

    public Item(Long itemId, String itemName, TypeOfItem typeOfItem) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.typeOfItem = typeOfItem;
    }

    public TypeOfItem getTypeOfItem() {
        return typeOfItem;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }
}
