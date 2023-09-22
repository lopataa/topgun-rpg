package Currency;

public class Copper extends CurrencyBase{
    public Copper(int quantity) {
        super(1, "Copper Coin", "copper_coin", 0.1f, quantity);
    }
}
