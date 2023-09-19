package Items;

public class Weapon extends Item {
    private final int damage;

    public Weapon(String name, String id, float weight, int damage) {
        super(name, id, weight);
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
