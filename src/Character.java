import Currency.Wallet;
import Items.Armor;
import Items.Item;
import Items.Shield;
import Items.Weapon;

import java.util.Random;

public class Character {
    protected String name;
    protected int max_health;
    protected int health;
    protected int dexterity;

    public Inventory inventory;

    public Weapon equippedWeapon;
    public Armor equippedArmor;
    public Shield equippedShield;

    public Wallet wallet;

    private int randInt(Random random, int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public Character(String name) {
        this.name = name;

        this.wallet = new Wallet();

        // setup random stuff
        Random random = new Random();
        // Set the seed by the name, so the character always has the same stats
        random.setSeed(name.hashCode());



        this.max_health = this.randInt(random, 10, 100);
        this.dexterity = this.randInt(random, 0, 50);
        float max_weight = this.randInt(random, 10, 50);

        // set health to max
        this.health = getMaxHealth();

        this.inventory = new Inventory(max_weight);
    }

    public void info() {
        System.out.printf("Character - %s:\n", this.name);
        System.out.printf("Left Hand: %s; Right Hand: %s; Items.Armor: %s\n", this.equippedShield.getName(), this.equippedWeapon.getName(), this.equippedArmor.getName());
        System.out.printf("- Health: %d / %d %s\n", this.getHealth(), this.getMaxHealth(), this.isAlive() ? "" : "(dead)");
        System.out.printf("- Dexterity: %d\n", this.dexterity);
        System.out.printf("- Weight: %.2f / %.2f\n", this.inventory.getCurrentWeight(), this.inventory.getMaxWeight());
        System.out.printf("- Inventory: [%s]\n\n", this.inventory);
    }

    public void equip(Item item) throws UnownedItemException {
        if (!this.inventory.getItems().contains(item)) {
            throw new UnownedItemException("Items.Item '" + item.getName() + "' is not owned by this character");
        }
        if (item instanceof Weapon) {
            this.equippedWeapon = (Weapon) item;
        } else if (item instanceof Armor) {
            this.equippedArmor = (Armor) item;
        } else if (item instanceof Shield) {
            this.equippedShield = (Shield) item;
        }
    }

    public boolean wasCriticalHit() {
        return (int) (Math.random() * 100) < this.dexterity;
    }

    public int criticalHitDamage(int damage) {
        // random number between 1 and 2
        float multiplier = (float) (Math.random() * (2 - 1)) + 1.1f;
        return (int) (damage * multiplier) - damage;
    }


    public int getMaxHealth() {
        return this.max_health;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public String getName() {
        return this.name;
    }


    public Weapon getWeapon() {
        return this.equippedWeapon;
    }

    public Armor getArmor() {
        return this.equippedArmor;
    }

    public Shield getShield() {
        return this.equippedShield;
    }


    public static class UnequippableItemException extends Exception {
        public UnequippableItemException(String message) {
            super(message);
        }
    }

    public static class UnownedItemException extends Exception {
        public UnownedItemException(String message) {
            super(message);
        }
    }
}
