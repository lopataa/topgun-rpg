package Items;

public class Weapon extends Item {
    private final int damage;

    public Weapon(String name, float weight, int damage) {
        super(name, weight);
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
