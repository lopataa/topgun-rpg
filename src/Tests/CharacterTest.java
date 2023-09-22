package Tests;

import Base.Inventory;
import Items.Armor;
import Items.Item;
import Items.Shield;
import Items.Weapon;
import org.junit.Test;
import org.junit.Assert;

import Base.Character;

public class CharacterTest {

    @Test
    public void testConstructor() {
        Character character = new Character("Test");

        Assert.assertEquals("Test", character.getName());
    }

    @Test
    public void testEquipWeapon() throws Character.UnownedItemException, Inventory.InventoryFullException, Character.BothHandsOccupiedException {
        Character character = new Character("Test");
        Weapon weapon = new Weapon("Sword", "sword", 10, 10);

        character.inventory.addItem(weapon);
        character.equip(weapon);

        Assert.assertEquals(weapon, character.getWeapon());
    }

    @Test
    public void testEquipArmor() throws Character.UnownedItemException, Inventory.InventoryFullException, Character.BothHandsOccupiedException {
        Character character = new Character("Test");
        Armor armor = new Armor("Chainmail", "chainmail_armor", 10, 10);

        character.inventory.addItem(armor);
        character.equip(armor);

        Assert.assertEquals(armor, character.getArmor());
    }

    @Test
    public void testEquipShield() throws Character.UnownedItemException, Inventory.InventoryFullException, Character.BothHandsOccupiedException {
        Character character = new Character("Test");
        Shield shield = new Shield("Wooden Shield", "wooden_shield", 10, 10);

        character.inventory.addItem(shield);
        character.equip(shield);

        Assert.assertEquals(shield, character.getShield());
    }

    @Test
    public void testUnownedItemException() {
        Character character = new Character("Test");
        Weapon weapon = new Weapon("Sword", "sword", 10, 10);

        Assert.assertThrows(Character.UnownedItemException.class, () -> character.equip(weapon));
    }

    @Test
    public void testInventoryFullException() {
        Character character = new Character("Test");
        Item reallyHeavyItem = new Item("Really Heavy Item", "really_heavy_item", 10000);

        Assert.assertThrows(Inventory.InventoryFullException.class, () -> character.inventory.addItem(reallyHeavyItem));
    }

    @Test
    public void testTakeDamage() {
        Character character = new Character("Test");

        int health = character.getHealth();

        character.takeDamage(5);

        Assert.assertEquals(health-5, character.getHealth());
    }

    @Test
    public void testHeal() {
        Character character = new Character("Test");

        character.takeDamage(5);

        character.heal(5);

        Assert.assertEquals(character.getHealth(), character.getMaxHealth());
    }

    @Test
    public void testHealCannotExceedMaxHealth() {
        Character character = new Character("Test");

        character.heal(5, true);

        Assert.assertTrue(character.getHealth() > character.getMaxHealth());
    }
}
