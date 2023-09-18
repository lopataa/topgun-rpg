public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        Character character = new Character("lopataa");

        try {
            character.inventory.addItem(new Item("Sword", 150f));
        } catch (Inventory.InventoryFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            character.inventory.addItem(new Item("Helmet", 240f));
        } catch (Inventory.InventoryFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            character.inventory.addItem(new Item("Orange", 4f));
        } catch (Inventory.InventoryFullException e) {
            System.out.println(e.getMessage());
        }
        try {
            character.inventory.addItem(new Item("Apple Pencil", 80f));
        } catch (Inventory.InventoryFullException e) {
            System.out.println(e.getMessage());
        }
        character.info();


    }
}