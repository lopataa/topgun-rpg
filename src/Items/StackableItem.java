package Items;

import Base.Character;

public class StackableItem extends Item {
    private int quantity;

    public StackableItem(String name, String id, float weight, int quantity) {
        super(name, id, weight);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        return this.getName() + " (x" + this.getQuantity() + ")";
    }

    @Override
    public float getWeight() {
        return this.getQuantity() * super.getWeight();
    }
}
