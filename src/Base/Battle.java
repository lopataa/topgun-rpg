package Base;

import Items.StackableItem;
import Items.Weapon;

public class Battle {

    private final Character opponent1;
    private final Character opponent2;

    private Items.Item[] reward;

    private int turn = 1;

    public Battle(Character opponent1, Character opponent2)
    {
        this.opponent1 = opponent1;
        this.opponent2 = opponent2;
    }

    public Battle(Character opponent1, Character opponent2, Items.Item[] reward)
    {
        this.opponent1 = opponent1;
        this.opponent2 = opponent2;

        this.reward = reward;
    }

    private void DEBUG() {
        this.opponent1.info();
        this.opponent2.info();
    }

    public void commence(boolean logAttack, boolean logWinner) throws Inventory.InventoryFullException
    {
        while (this.opponent1.isAlive() && this.opponent2.isAlive())
        {
            this.attack(this.opponent1, this.opponent2, logAttack);
            if (!this.opponent2.isAlive())
                break;
            this.attack(this.opponent2, this.opponent1, logAttack);
        }

        Character winner = this.getWinner();
        if (winner != null) {
            System.out.printf("%s has won the battle in %d turns!\n", winner.getName(), this.turn);

            // if rewards exist, give them to the winner
            if (this.reward != null) {
                // print the rewards
                StringBuilder rewards = new StringBuilder();
                rewards.append("Winner won: [");
                for (Items.Item item : this.reward) {

                    rewards.append(item.getName());
                    // if the item is stackable, print the quantity
                    if (item instanceof Items.StackableItem)
                        rewards.append(" (x").append(((StackableItem) item).getQuantity()).append(")");

                    if (this.reward[this.reward.length - 1] != item)
                        rewards.append(", ");
                }
                rewards.append("]");
                System.out.println(rewards);

                // add the items to the winner's inventory
                winner.inventory.addItems(this.reward);
            }
                System.out.println();
        }
        else
            System.out.println("The battle was a draw!");
    }

    public void commence() throws Inventory.InventoryFullException {
        this.commence(true, true);
    }

    public void attack(Character attacker, Character defender, boolean logAttack) {
        if (logAttack)
            System.out.printf("TURN %d: %s attacks %s\n", this.turn, attacker.getName(), defender.getName());

        Weapon weapon;
        if (attacker.getWeapon() == null)
            weapon = new Weapon("Fists", "fists", 0.0f, 1);
        else
            weapon = attacker.getWeapon();

        int damage = weapon.getDamage();
        int criticalHit = attacker.wasCriticalHit() ? attacker.criticalHitDamage(damage) : 0;

        if (logAttack)
            System.out.printf("%s attacks with %s for %d +%d damage\n", attacker.getName(), weapon.getName(), damage, criticalHit);


        if (defender.getShield() != null && defender.getShield().wasBlocked()) {
            if (logAttack)
                System.out.printf("%s blocked the attack with %s!\n", defender.getName(), defender.getShield().getName());
            return;
        }
        else if (defender.getArmor() != null) {
            if (logAttack)
                System.out.printf("%s's armor (%s) absorbed %d damage\n", defender.getName(), defender.getArmor().getName(), defender.getArmor().getDefense());
            damage -= defender.getArmor().getDefense();
        }
        damage += criticalHit;

        if (damage < 0)
            damage = 0;

        defender.takeDamage(damage);
        if (logAttack)
            System.out.printf("%s took %d damage\n", defender.getName(), damage);

        if (logAttack) {
            if (!defender.isAlive())
                System.out.printf("%s died!\n", defender.getName());
            else
                System.out.printf("%s has %d health left\n", defender.getName(), defender.getHealth());
            System.out.println();
        }

        this.turn++;
    }

    public Character getWinner()
    {
        if (!this.opponent1.isAlive() && this.opponent2.isAlive())
            return this.opponent2;
        else if (this.opponent1.isAlive() && !this.opponent2.isAlive())
            return this.opponent1;
        return null;
    }
}
