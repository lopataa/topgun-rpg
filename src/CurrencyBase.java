public class CurrencyBase {
    protected int value;
    protected String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public CurrencyBase(int value, String name) {
        this.value = value;
        this.name = name;
    }
}