package Base;

import Items.Weapon;

public class Battle {

    private final Character opponent1;
    private final Character opponent2;

    private int turn = 1;

    public Battle(Character opponent1, Character opponent2)
    {
        this.opponent1 = opponent1;
        this.opponent2 = opponent2;
    }

    private void DEBUG() {
        this.opponent1.info();
        this.opponent2.info();
    }

    public void commence()
    {
        while (this.opponent1.isAlive() && this.opponent2.isAlive())
        {
            this.attack(this.opponent1, this.opponent2);
            if (!this.opponent2.isAlive())
                break;
            this.attack(this.opponent2, this.opponent1);
        }

        Character winner = this.getWinner();
        if (winner != null)
            System.out.printf("%s has won the battle in %d turns!\n", winner.getName(), this.turn);
        else
            System.out.println("The battle was a draw!");
    }

    public void attack(Character attacker, Character defender) {
        System.out.printf("TURN %d: %s attacks %s\n", this.turn, attacker.getName(), defender.getName());

        Weapon weapon;
        if (attacker.getWeapon() == null)
            weapon = new Weapon("Fists", "fists", 0.0f, 1);
        else
            weapon = attacker.getWeapon();

        int damage = weapon.getDamage();
        int criticalHit = attacker.wasCriticalHit() ? attacker.criticalHitDamage(damage) : 0;
        int dexterity = attacker.getDexterity(); // chance for critical hit


        System.out.printf("%s attacks with %s for %d +%d damage\n", attacker.getName(), weapon.getName(), damage, criticalHit);


        if (defender.getShield() != null && defender.getShield().wasBlocked()) {
            System.out.printf("%s blocked the attack with %s!\n", defender.getName(), defender.getShield().getName());
            return;
        }
        else if (defender.getArmor() != null) {
            System.out.printf("%s's armor (%s) absorbed %d damage\n", defender.getName(), defender.getArmor().getName(), defender.getArmor().getDefense());
            damage -= defender.getArmor().getDefense();
        }
        damage += criticalHit;

        if (damage < 0)
            damage = 0;

        defender.takeDamage(damage);
        System.out.printf("%s took %d damage\n", defender.getName(), damage);

        if (!defender.isAlive())
            System.out.printf("%s died!\n", defender.getName());
        else
            System.out.printf("%s has %d health left\n", defender.getName(), defender.getHealth());

        System.out.println();
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
