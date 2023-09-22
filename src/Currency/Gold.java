package Currency;

public class Gold extends CurrencyBase {
    public Gold(int quantity) {
        super(100, "Gold Coin", "gold_coin", 0.3f, quantity);
    }
}
