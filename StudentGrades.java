package mypack;

//import java.util.Random;
//import java.util.Scanner;
//
//public class GuessTheNumberGame {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//        int maxRounds = 5; // Maximum number of rounds to play
//        int maxAttempts = 5; // Maximum number of attempts per round
//        int roundsWon = 0;
//        
//        System.out.println("Welcome to the Guess the Number Game!");
//        System.out.println("You have " + maxRounds + " rounds to play. Let's begin!\n");
//
//        for (int round = 1; round <= maxRounds; round++) {
//            int targetNumber = random.nextInt(100) + 1;
//            int attempts = 0;
//            boolean guessedCorrectly = false;
//            
//            System.out.println("Round " + round + ": Guess the number between 1 and 100!");
//            
//            while (attempts < maxAttempts) {
//                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
//                int userGuess = scanner.nextInt();
//                attempts++;
//                
//                if (userGuess == targetNumber) {
//                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
//                    roundsWon++;
//                    guessedCorrectly = true;
//                    break;
//                } else if (userGuess < targetNumber) {
//                    System.out.println("Too low! Try again.");
//                } else {
//                    System.out.println("Too high! Try again.");
//                }
//            }
//            
//            if (!guessedCorrectly) {
//                System.out.println("Sorry! You've used all attempts. The correct number was " + targetNumber + ".");
//            }
//            System.out.println();
//        }
//        
//        System.out.println("Game Over!");
//        System.out.println("Rounds won: " + roundsWon + "/" + maxRounds);
//        System.out.println("Thank you for playing!");
//        
//        scanner.close();
//    }
//}
//
//
import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int[] marks = new int[numSubjects];

        // Input marks for each subject
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Determine grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}




