package mypack;
import java.util.Scanner;
import java.util.Random;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean play = true;
        int totalScore = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");

        while (play) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number between 1 and 100. You have " + maxAttempts + " attempts!");

           
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Score based on remaining attempts
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + numberToGuess);
            }
            
            System.out.print("Would you like to play another round? (yes/no): ");
            play = scanner.next().equalsIgnoreCase("yes");
        }
        
        System.out.println("Game over! Your total score is: " + totalScore);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
