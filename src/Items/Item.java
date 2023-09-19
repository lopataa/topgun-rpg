package Items;

import Base.Character;

public class Item {
    private final String name;
    private final String id; // should be unique, items get stacked by it
    private final float weight;

    public Item(String name, String id, float weight) {
        this.name = name;
        this.id = id;
        this.weight = weight;
    }

    public void use() {}
    public void use(Character character) {}

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public float getWeight() {
        return this.weight;
    }

    public String toString() {
        return String.format("%s (%s)", this.getName(), this.getId());
    }
}
