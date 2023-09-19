package Items.Special;

import Base.Character;

public class LetterFromMom extends Items.Item {

    private static boolean hasBeenRead = false;

    public LetterFromMom() {
        super("Letter from Mom", "letter_from_mom", 0.1f);
    }

    public void use(Character character) {
        System.out.printf("%s reads the letter.\n", character.getName());
        String message = """
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                 Dear %s,
                 I hope you like this poet I made for you. <3
                            
                 Roses are red,
                 violets are blue,
                 this game is awesome,
                 and so are you.
                            
                 Love,
                 mom <3
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                """;
        System.out.printf((message) + "%n", character.getName());
        if (!hasBeenRead) {
            character.heal(5, true);
            System.out.println("It's a letter from your mom! It's so sweet, that it healed you for 5 HP.");
            System.out.printf("%s's HP is now %d!\n\n", character.getName(), character.getHealth());
            hasBeenRead = true;
        }
    }
}
