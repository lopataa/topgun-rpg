import Base.Character;
import Base.Inventory;
import Items.Armor;
import Items.Shield;
import Items.Special.LetterFromMom;
import Items.Weapon;
import Base.Battle;

public class Main {
    public static void main(String[] args) throws Character.UnownedItemException, Inventory.InventoryFullException, Character.BothHandsOccupiedException {
        System.out.println("Hello world!\n");

        Character attacker = new Character("peter");
        Character defender = new Character("paul");

        Weapon weapon = new Weapon("Sword", "sword", 10, 10);

        attacker.inventory.addItem(weapon);
        attacker.equip(weapon);

        Armor armor = new Armor("Chainmail", "chainmail_armor", 10, 9);
        defender.inventory.addItem(armor);
        defender.equip(armor);

        Battle battle = new Battle(attacker, defender, new Items.Item[]{
            new Currency.Gold(2),
        });

        attacker.inventory.addItem(new Currency.Gold(10));
        attacker.info();

        battle.commence(false, true);

        attacker.info();
    }
}