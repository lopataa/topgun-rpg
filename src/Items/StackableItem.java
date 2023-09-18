package Items;

public class StackableItem extends Item {
    private final int quantity;

    public StackableItem(String name, float weight, int quantity) {
        super(name, weight);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
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
