package Tests;

import Base.Inventory;
import Items.Item;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class InventoryTest {
    @Test
    public void testConstructor() {
        Inventory inventory = new Inventory(100.0f);
        Assert.assertEquals(100.0f, inventory.getMaxWeight(), 0);
        Assert.assertEquals(0.0f, inventory.getCurrentWeight(), 0);
        Assert.assertEquals(0, inventory.getItems().size());
    }

    @Test
    public void testAddItem() throws Inventory.InventoryFullException {
        Inventory inventory = new Inventory(100.0f);
        Item item1 = new Item("Item 1","item_1", 50.0f);
        Item item2 = new Item("Item 2", "item_2", 25.0f);

        inventory.addItem(item1);
        inventory.addItem(item2);

        Assert.assertEquals(75, inventory.getCurrentWeight(), 0);

        Assert.assertEquals(2, inventory.getItems().size());

        Item item3 = new Item("Item 3", "item_3", 30.0f);
        Assert.assertThrows(Inventory.InventoryFullException.class, () -> inventory.addItem(item3));
    }

    @Test
    public void testGetItem() throws Inventory.InventoryFullException {
        Inventory inventory = new Inventory(100.0f);
        Item item1 = new Item("Item 1", "item_1", 50.0f);
        Item item2 = new Item("Item 2", "item_2",25.0f);

        inventory.addItem(item1);
        inventory.addItem(item2);

        Item retrievedItem1 = inventory.getItem("item_1");
        Assert.assertEquals(item1, retrievedItem1);

        Item retrievedItem2 = inventory.getItem("item_2");
        Assert.assertEquals(item2, retrievedItem2);

        Item retrievedItem3 = inventory.getItem("item_3");
        Assert.assertNull(retrievedItem3);
    }

    @Test
    public void testGetItems() throws Inventory.InventoryFullException {
        Inventory inventory = new Inventory(100.0f);
        Item item1 = new Item("Item 1", "item_1", 50.0f);
        Item item2 = new Item("Item 2", "item_2",25.0f);

        inventory.addItem(item1);
        inventory.addItem(item2);

        ArrayList<Item> retrievedItems = inventory.getItems();

        Assert.assertEquals(2, retrievedItems.size());
        Assert.assertTrue(retrievedItems.contains(item1));
        Assert.assertTrue(retrievedItems.contains(item2));
    }

    @Test
    public void testToString() throws Inventory.InventoryFullException {
        Inventory inventory = new Inventory(100.0f);
        Item item1 = new Item("Item 1", "item_1", 50.0f);
        Item item2 = new Item("Item 2", "item_1",25.0f);

        inventory.addItem(item1);
        inventory.addItem(item2);

        String inventoryString = inventory.toString();

        Assert.assertTrue(inventoryString.contains(item1.getName()));
        Assert.assertTrue(inventoryString.contains(item2.getName()));
    }

    @Test
    public void testInventoryFullException() throws Inventory.InventoryFullException {
        Inventory inventory = new Inventory(100.0f);
        Item item1 = new Item("Item 1", "item_1", 50.0f);
        Item item2 = new Item("Item 2", "item_2",25.0f);

        inventory.addItem(item1);
        inventory.addItem(item2);

        Item item3 = new Item("Item 3", "item_3", 30.0f);
        Assert.assertThrows(Inventory.InventoryFullException.class, () -> inventory.addItem(item3));
    }
}
