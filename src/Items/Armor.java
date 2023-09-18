package Items;

public class Armor extends Item {
    private final int defense;

    public Armor(String name, float weight, int defense) {
        super(name, weight);
        this.defense = defense;
    }

    public int getDefense() {
        return this.defense;
    }
}
