import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        // Initialize scanner and random number generator
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        // Main loop for playing the game
        do {
            playGame(scanner, random); // Call playGame method to start the game
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        } while (playAgain);

        // End of game message
        System.out.println("Thank you for playing Guess the Number!");
        scanner.close(); // Close the scanner to free resources
    }

    // Method to play the game
    private static void playGame(Scanner scanner, Random random) {
        System.out.println("\nWelcome to the Guess the Number game!");
        System.out.println("Choose a difficulty level: (easy/medium/hard)");
        System.out.print("Enter your choice: ");
        String difficulty = scanner.next();

        int maxAttempts;
        // Set maximum attempts based on the chosen difficulty level
        switch (difficulty.toLowerCase()) {
            case "easy":
                maxAttempts = 10;
                break;
            case "medium":
                maxAttempts = 7;
                break;
            case "hard":
                maxAttempts = 5;
                break;
            default:
                // Default to medium difficulty if an invalid choice is entered
                System.out.println("Invalid difficulty level. Defaulting to medium.");
                maxAttempts = 7;
                break;
        }

        // Generate a random number between 1 and 100
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;

        System.out.println("I've picked a number between 1 and 100. Can you guess it?");
        System.out.println("You have " + maxAttempts + " attempts.");

        // Main game loop
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                attempts++;

                // Check if the guess is correct, too low, or too high
                if (guess == secretNumber) {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    return;
                } else if (guess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            } else {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Message displayed when all attempts are used without guessing the correct number
        System.out.println("Sorry, you've used all your attempts. The number was: " + secretNumber);
    }
}


