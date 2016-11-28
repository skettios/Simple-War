import java.util.Random;
import java.util.Scanner;

public class Lab4 {
    private static int[] cardAmounts = {
            4, 4, 4, 4,
            4, 4, 4, 4,
            4, 4, 4, 4, 4
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random(System.currentTimeMillis());

        System.out.print("Enter your name: ");
        String name = enterName(input);
        System.out.println("Welcome to war " + name + "!");

        boolean keepPlaying = false;

        do {
            boolean anotherRound = false;

            do {
                int playerCard = drawCard(random);
                int computerCard = drawCard(random);

                System.out.println(name + " " + getCardSymbol(playerCard) + " : " + getCardSymbol(computerCard) + " Computer");

                if (playerCard > computerCard) {
                    System.out.println(name + " has won the round!");
                    anotherRound = false;
                } else if (playerCard < computerCard) {
                    System.out.println("Computer has won the round!");
                    anotherRound = false;
                } else {
                    anotherRound = true;
                }
            } while (anotherRound);

            System.out.print("Play again? (Y/N): ");
            char answer = input.nextLine().toUpperCase().charAt(0);
            if (answer == 'Y')
                keepPlaying = true;
            else if (answer == 'N')
                keepPlaying = false;

        } while (keepPlaying);
    }

    private static String enterName(Scanner input) {
        String name = null;

        do {
            name = input.nextLine();
        } while (name.length() < 0);

        return name;
    }

    private static int drawCard(Random random) {
        int cardValue = 0;

        do {
            cardValue = random.nextInt(12);
        } while (cardAmounts[cardValue] <= 0);

        cardAmounts[cardValue] -= 1;

        return cardValue + 1;
    }

    private static String getCardSymbol(int value) {
        switch (value) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(value);
        }
    }
}
