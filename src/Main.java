import Items.Armor;
import Items.Shield;
import Items.Weapon;

public class Main {
    public static void main(String[] args) throws Character.UnownedItemException, Inventory.InventoryFullException {
        System.out.println("Hello world!\n");

        Character attacker = new Character("peter");
        Character defender = new Character("paul");

        // lets equip both characters with a weapon
        Weapon weapon = new Weapon("Sharp Sword", 1.0f, 10);
        attacker.inventory.addItem(weapon);
        defender.inventory.addItem(weapon);
        attacker.equip(weapon);
        defender.equip(weapon);

        // lets equip both characters with a shield
        Shield shield = new Shield("Cool Items.Shield", 0.5f, 5);
        attacker.inventory.addItem(shield);
        defender.inventory.addItem(shield);
        attacker.equip(shield);
        defender.equip(shield);

        // lets equip both characters with an armor
        Armor armor = new Armor("Tough Items.Armor", 0.5f, 5);
        attacker.inventory.addItem(armor);
        defender.inventory.addItem(armor);
        attacker.equip(armor);
        defender.equip(armor);

        attacker.info();
        defender.info();

        Battle battle = new Battle(attacker, defender);

        battle.commence();

        attacker.info();
        defender.info();

    }
}