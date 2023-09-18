package Items;

public class Item {
    private final String name;
    private final float weight;

    public Item(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public float getWeight() {
        return this.weight;
    }
}
