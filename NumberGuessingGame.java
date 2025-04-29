import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        int round = 1;
        String playAgain = "y";

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        while (playAgain.equalsIgnoreCase("y")) {
            int secretNumber = rand.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\n🔁 Round " + round + ":");
            System.out.println("Guess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": ");
                int guess;

                // Handle non-integer input
                if (!sc.hasNextInt()) {
                    System.out.println("⚠️ Please enter a valid number.");
                    sc.next(); // discard invalid input
                    attempt--; // don't count this attempt
                    continue;
                }

                guess = sc.nextInt();

                if (guess == secretNumber) {
                    System.out.println("🎉 Correct! You've guessed the number.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("🔻 Too low!");
                } else {
                    System.out.println("🔺 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts! The number was: " + secretNumber);
            }

            System.out.println("📊 Your current score: " + score);
            System.out.print("Do you want to play another round? (y/n): ");
            playAgain = sc.next();
            round++;
        }

        System.out.println("👋 Thanks for playing! Final Score: " + score);
        sc.close();
    }
}
