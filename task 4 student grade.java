package mypack;


import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int QUESTION_TIME_LIMIT = 10; // Time limit per question in seconds
    private static int score = 0; // User's score
    private static boolean answerSubmitted = false;
    private static String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "What is the largest mammal?",
        "Who wrote 'To Kill a Mockingbird'?"
    };
    private static String[][] options = {
        {"A) London", "B) Berlin", "C) Paris", "D) Rome"},
        {"A) Earth", "B) Mars", "C) Jupiter", "D) Saturn"},
        {"A) Elephant", "B) Blue Whale", "C) Great White Shark", "D) Giraffe"},
        {"A) Ernest Hemingway", "B) Harper Lee", "C) F. Scott Fitzgerald", "D) Mark Twain"}
    };
    private static char[] correctAnswers = {'C', 'B', 'B', 'B'};
    private static char[] userAnswers = new char[questions.length];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Quiz Application!");
        
        // Iterate through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

            // Start the timer
            Timer timer = new Timer();
            answerSubmitted = false;

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (!answerSubmitted) {
                        System.out.println("\nTime's up! Moving to the next question.");
                        userAnswers[i] = ' '; // No answer submitted
                        answerSubmitted = true;
                        timer.cancel();
                    }
                }
            };

            timer.schedule(task, QUESTION_TIME_LIMIT * 1000);

            // Get user's answer if they respond in time
            System.out.print("Enter your answer (A, B, C, or D): ");
            String answer = scanner.next();
            if (!answerSubmitted) {
                userAnswers[i] = answer.toUpperCase().charAt(0);
                answerSubmitted = true;
                timer.cancel();
            }

            // Check if the answer is correct
            if (userAnswers[i] == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + correctAnswers[i]);
            }
        }

        // Display the final result
        System.out.println("\n--- Quiz Results ---");
        System.out.println("Your final score is: " + score + "/" + questions.length);
        
        for (int i = 0; i < questions.length; i++) {
            System.out.print("Question " + (i + 1) + ": ");
            if (userAnswers[i] == correctAnswers[i]) {
                System.out.println("Correct");
            } else if (userAnswers[i] == ' ') {
                System.out.println("No answer submitted");
            } else {
                System.out.println("Incorrect (Your answer: " + userAnswers[i] + ", Correct answer: " + correctAnswers[i] + ")");
            }
        }
        
        scanner.close();
    }
}
