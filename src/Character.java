import java.util.Random;

public class Character {
    protected String name;
    protected int damage;
    protected int max_health;
    protected int dexterity;

    public Inventory inventory;

    public Wallet wallet;

    private int randInt(Random random, int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public Character(String name) {
        this.name = name;

        this.wallet = new Wallet();

        // setup random stuff
        Random random = new Random();
        // Set the seed by the name, so the character always has the same stats
        random.setSeed(name.hashCode());



        this.damage = this.randInt(random, 0, 32);
        this.max_health = this.randInt(random, 10, 100);
        this.dexterity = this.randInt(random, 0, 250);
        float max_weight = this.randInt(random, 0, 2500);

        this.inventory = new Inventory(max_weight);
    }

    public void info() {
        System.out.printf("Character - %s:\n", this.name);
        System.out.printf("- Damage: %d\n", this.damage);
        System.out.printf("- Max Health: %d\n", this.max_health);
        System.out.printf("- Dexterity: %d\n", this.dexterity);
        System.out.printf("- Weight: %.2f / %.2f\n", this.inventory.getCurrentWeight(), this.inventory.getMaxWeight());
        System.out.printf("- Inventory: [%s]\n", this.inventory);
    }

    public int getDamage() {
        return this.damage;
    }

    public int getMaxHealth() {
        return this.max_health;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public String getName() {
        return this.name;
    }
}
