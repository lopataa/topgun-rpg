package Currency;

public class CurrencyBase extends Items.StackableItem {
    protected int value;
    protected String name;

    public int getBaseValue() {
        return this.value;
    }

    public int getValue() {
        return this.value * this.getQuantity();
    }

    public CurrencyBase(int value, String name, String id, float weight, int quantity) {
        super(name, id, weight, quantity);

        this.value = value;
        this.name = name;
    }
}