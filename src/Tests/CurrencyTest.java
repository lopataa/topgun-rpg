package Tests;

import Currency.Currency;
import org.junit.Test;
import org.junit.Assert;

public class CurrencyTest {
    @Test
    public void testCurrencyValues() {
        Assert.assertEquals(1, Currency.COPPER.getValue());
        Assert.assertEquals(10, Currency.SILVER.getValue());
        Assert.assertEquals(100, Currency.GOLD.getValue());
    }

    @Test
    public void testWallet() {
        Wallet wallet = new Wallet();

        wallet.addMoney(Currency.GOLD, 5);
        Assert.assertEquals(500, wallet.getMoney(Currency.COPPER));

        wallet.removeMoney(Currency.GOLD, 2);
        Assert.assertEquals(300, wallet.getMoney(Currency.COPPER));
    }
}