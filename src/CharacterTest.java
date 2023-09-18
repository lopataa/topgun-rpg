import org.junit.Test;
import org.junit.Assert;

public class CharacterTest {

    @Test
    public void testCharacterStats() {
        Character character = new Character("test");
        Assert.assertEquals("test", character.getName());
        Assert.assertEquals(5, character.getDamage());
        Assert.assertEquals(24, character.getMaxHealth());
        Assert.assertEquals(204, character.getDexterity());
    }

    @Test
    public void testCharacterWallet() {
        Character character = new Character("test");

        character.wallet.addMoney(Currency.GOLD, 5);
        Assert.assertEquals(500, character.wallet.getMoney(Currency.COPPER));

        character.wallet.removeMoney(Currency.GOLD, 2);
        Assert.assertEquals(300, character.wallet.getMoney(Currency.COPPER));
    }
}