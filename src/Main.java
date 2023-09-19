import Base.Character;
import Base.Inventory;
import Items.Armor;
import Items.Shield;
import Items.Special.LetterFromMom;
import Items.Weapon;

public class Main {
    public static void main(String[] args) throws Character.UnownedItemException, Inventory.InventoryFullException {
        System.out.println("Hello world!\n");

        Character attacker = new Character("peter");
        Character defender = new Character("paul");

        System.out.printf("%s found a letter!\n", attacker.getName());
        attacker.inventory.addItem(new LetterFromMom());
        attacker.inventory.getItem("letter_from_mom").use(attacker);

        attacker.info();


    }
}