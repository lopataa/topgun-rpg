package Currency;

public class Silver extends CurrencyBase {
    public Silver(int quantity) {
        super(10, "Silver Coin", "silver_coin", 0.2f, quantity);
    }
}
