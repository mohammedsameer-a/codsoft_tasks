import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("=== Number Guessing Game ===");
        while (playAgain) {
            int secret = random.nextInt(100) + 1; // 1 through 100
            int maxAttempts = 7;
            boolean guessed = false;
            System.out.println("I picked a number from 1 to 100. You have " + maxAttempts + " guesses.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Guess " + attempt + ": ");
                int guess = readInt(input);
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number from 1 to 100.");
                    attempt--; // an invalid entry does not use a guess
                } else if (guess == secret) {
                    System.out.println("Correct! You got it in " + attempt + " guess(es).");
                    guessed = true;
                    roundsWon++;
                    break;
                } else if (guess < secret) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }
            }
            if (!guessed) System.out.println("Out of guesses. The number was " + secret + ".");
            System.out.println("Rounds won: " + roundsWon);
            System.out.print("Play another round? (y/n): ");
            playAgain = input.nextLine().trim().equalsIgnoreCase("y");
        }
        System.out.println("Thanks for playing!");
        input.close();
    }

    private static int readInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Enter a whole number: ");
            input.next();
        }
        int value = input.nextInt();
        input.nextLine();
        return value;
    }
}

