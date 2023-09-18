package Items;

public class Shield extends Item {
    private final int blockChance;

    public Shield(String name, float weight, int blockChance) {
        super(name, weight);
        this.blockChance = blockChance;
    }

    public int getBlockChance() {
        return this.blockChance;
    }

    public boolean wasBlocked() {
        return (int) (Math.random() * 100) < this.blockChance;
    }
}
