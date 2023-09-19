package Items.Special;

import Base.Character;
import Items.StackableItem;

public class Apple extends StackableItem {
    public Apple(int quantity) {
        super("Apple", "apple", 0.1f, quantity);
    }

    public void use(Character character) {
        character.heal(5);
        this.removeQuantity(1);
    }

}
