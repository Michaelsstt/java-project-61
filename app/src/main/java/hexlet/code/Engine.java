package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void runGame(String gameDescription, String[][] gameData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        System.out.println(gameDescription);

        for (String[] roundData : gameData) {
            String question = roundData[0];
            String correctAnswer = roundData[1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + userName + "!");
    }

    public static class Utils {
    }
}
