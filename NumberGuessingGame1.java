import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1, maxRange = 100, attemptsLimit = 5, score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I have generated a number between " + minRange + " and " + maxRange + ". Guess the number!");
            int attempts = 0;

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == attemptsLimit) {
                System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            if (!scanner.next().toLowerCase().startsWith("y")) {
                break;
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
