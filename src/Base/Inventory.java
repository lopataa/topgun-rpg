package Base;

import Items.Item;
import Items.StackableItem;

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

    public void addItems(Item[] items) throws Inventory.InventoryFullException {
        for (Item item : items) {
            this.addItem(item);
        }
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
        return this.getItems(false);
    }

    public ArrayList<Item> getItems(boolean stackItems) {
        if (!stackItems) {
            return this.items;
        }

        // might redo it later
        // this is a very inefficient way of doing it
        // this returns a new arraylist with the items stacked
        ArrayList<Item> result = new ArrayList<Item>();
        for (Item item : this.items) {
            if (item instanceof StackableItem) {
                boolean found = false;
                for (Item i : result) {
                    if (i.getId().equals(item.getId())) {
                        ((StackableItem) i).addQuantity(((StackableItem) item).getQuantity());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result.add(item);
                }
            } else {
                result.add(item);
            }
        }
        return result;
    }

    public String toString(boolean stackItems) {
        StringBuilder result = new StringBuilder();
        ArrayList<Item> items = this.getItems(stackItems);

        for (Item item : items) {
            result.append(item.getName());
            if (item instanceof Items.StackableItem) {
                result.append(String.format(" (x%d)", ((Items.StackableItem) item).getQuantity()));
            }
            if (items.indexOf(item) != items.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    public int getMoney() {
        int total = 0;
        for (Item item : this.getItems(false)) {
            if (item instanceof Currency.CurrencyBase) {
                total += ((Currency.CurrencyBase) item).getValue();
            }
        }
        return total;
    }

    public String toString() {
        return this.toString(true);
    }

    public static class InventoryFullException extends Exception {
        public InventoryFullException(String message) {
            super(message);
        }
    }
}
