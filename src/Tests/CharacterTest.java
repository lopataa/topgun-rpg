package Tests;

import Currency.Currency;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import org.junit.Test;
import org.junit.Assert;

public class CharacterTest {

    @Test
    public void stats() {
        Character character = new Character("test");
        Assert.assertEquals("test", character.getName());
        Assert.assertEquals(24, character.getMaxHealth());
        Assert.assertEquals(204, character.getDexterity());
    }

    @Test
    public void wallet() {
        Character character = new Character("test");

        character.wallet.addMoney(Currency.GOLD, 5);
        Assert.assertEquals(500, character.wallet.getMoney(Currency.COPPER));

        character.wallet.removeMoney(Currency.GOLD, 2);
        Assert.assertEquals(300, character.wallet.getMoney(Currency.COPPER));
    }

    @Test
    public void inventory() throws Exception {
        Character character = new Character("test");
        Armor armor = new Armor("test", 1.0f, 1);
        Weapon weapon = new Weapon("test", 1.0f, 1);
        Item reallyHeavyItem = new Item("test", 25000.0f);

        character.inventory.addItem(armor);
        character.inventory.addItem(weapon);

        Assert.assertThrows(Inventory.InventoryFullException.class, () -> {
            character.inventory.addItem(reallyHeavyItem);
        });

    }
}