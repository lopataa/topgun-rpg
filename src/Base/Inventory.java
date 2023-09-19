package Base;

import Items.Item;

import java.util.ArrayList;

public class Inventory {
    private final float maxWeight;
    private final ArrayList<Item> items;

    public Inventory(float maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<Item>();
    }

    public float getMaxWeight() {
        return this.maxWeight;
    }

    public float getCurrentWeight() {
        float total = 0;
        for (Item item : this.items) {
            total += item.getWeight();
        }
        return total;
    }

    public void addItem(Item item) throws Inventory.InventoryFullException {
        if (this.getCurrentWeight() + item.getWeight() > this.getMaxWeight()) {
            throw new InventoryFullException(
                    String.format("Items.Item '%s' is too heavy to be added to the inventory", item.getName())
            );
        }
        this.items.add(item);
    }

    public <T extends Item> T getItem(String id) {
        for (Item i : this.items) {
            if (i.getId().equals(id)) {
                return (T) i;
            }
        }
        return null;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Item item : this.items) {
            result.append(item.getName());
            if (this.items.indexOf(item) != this.items.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public static class InventoryFullException extends Exception {
        public InventoryFullException(String message) {
            super(message);
        }
    }
}
