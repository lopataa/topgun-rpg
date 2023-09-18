package Currency;

import java.util.HashMap;

public class Wallet {
    private final HashMap<CurrencyBase, Integer> money;

    public Wallet() {
        this.money = new HashMap<CurrencyBase, Integer>();
    }

    public void addMoney(CurrencyBase currency, int amount) {
        if (this.money.containsKey(currency)) {
            this.money.put(currency, this.money.get(currency) + amount);
        } else {
            this.money.put(currency, amount);
        }
    }

    public void removeMoney(CurrencyBase currency, int amount) {
        if (this.money.containsKey(currency)) {
            this.money.put(currency, this.money.get(currency) - amount);
        } else {
            this.money.put(currency, -amount);
        }
    }

    public void printMoney() {
        for (CurrencyBase currency : this.money.keySet()) {
            System.out.printf("%s: %d\n", currency.getName(), this.money.get(currency));
        }
    }

    public int getCurrency(CurrencyBase currency) {
        if (this.money.containsKey(currency)) {
            return this.money.get(currency);
        }
        return 0;
    }
    
    public int getMoney(CurrencyBase currency) {
        int total = 0;
        for (CurrencyBase i : this.money.keySet()) {
            total += this.money.get(i) * i.getValue();
        }
        return total * currency.getValue();
    }

}