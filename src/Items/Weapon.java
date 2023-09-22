package Items;

public class Weapon extends Item {
    private final int damage;

    private final boolean requiresTwoHands;

    public Weapon(String name, String id, float weight, int damage, boolean requiresTwoHands) {
        super(name, id, weight);
        this.damage = damage;
        this.requiresTwoHands = requiresTwoHands;
    }

    public Weapon(String name, String id, float weight, int damage) {
        this(name, id, weight, damage, false);
    }

    public int getDamage() {
        return this.damage;
    }

    public boolean requiresTwoHands() {
        return this.requiresTwoHands;
    }
}
