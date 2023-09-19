package Items;

public class Armor extends Item {
    private final int defense;

    public Armor(String name, String id, float weight, int defense) {
        super(name, id, weight);
        this.defense = defense;
    }

    public int getDefense() {
        return this.defense;
    }
}
