package Tests;

    import Base.Battle;
    import Base.Inventory;
import Base.Character;
import Items.Weapon;
    import org.junit.Test;
    import org.junit.Assert;


    public class BattleTest {

        @Test
        public void testAttack() throws Character.BothHandsOccupiedException, Character.UnownedItemException, Inventory.InventoryFullException {
            Character attacker = new Character("Attacker");
            Character defender = new Character("Defender");

            Battle battle = new Battle(attacker, defender);

            battle.attack(attacker, defender, false);

            // check that the defender's health has decreased
            Assert.assertTrue(defender.getHealth() < defender.getMaxHealth());
        }

        @Test
        public void testAttackWithShield() throws Inventory.InventoryFullException, Character.BothHandsOccupiedException, Character.UnownedItemException {
            Character attacker = new Character("Attacker");
            Character defender = new Character("Defender");

            Items.Shield shield = new Items.Shield("Shield", "shield", 0.0f, 100);
            defender.inventory.addItem(shield);
            defender.equip(shield);

            Battle battle = new Battle(attacker, defender);

            battle.attack(attacker, defender, false);

            // check if the damage was blocked
            Assert.assertTrue(defender.getHealth() == defender.getMaxHealth());
        }

        @Test
        public void testAttackWithArmor() throws Inventory.InventoryFullException, Character.BothHandsOccupiedException, Character.UnownedItemException {
            Character attacker = new Character("Attacker");
            Character defender = new Character("Defender");

            Items.Armor armor = new Items.Armor("Armor", "armor", 0.0f, 50);
            defender.inventory.addItem(armor);
            defender.equip(armor);

            Battle battle = new Battle(attacker, defender);

            battle.attack(attacker, defender, false);

            // check that the defender's health has not decreased by the full damage amount
            Assert.assertTrue(defender.getHealth() > defender.getMaxHealth() - 1);
        }

        @Test
        public void testGetWinner() throws Inventory.InventoryFullException {
            Character opponent1 = new Character("Opponent 1");
            Character opponent2 = new Character("Opponent 2");

            Battle battle = new Battle(opponent1, opponent2);

            Assert.assertNull(battle.getWinner());

            battle.commence();

            // one of the characters should be the winner after the battle has commenced
            Assert.assertNotNull(battle.getWinner());
        }
    }
