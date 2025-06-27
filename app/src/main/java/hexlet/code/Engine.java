package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void runGame(String gameDescription, String[][] gameData) {
        Scanner scanner = new Scanner(System.in);

        Cli.greetings();

        System.out.println(gameDescription);

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            String question = gameData[i][0];
            String correctAnswer = gameData[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (!answer.equals(correctAnswer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                System.out.println("Let's try again, " + Cli.getUserName() + "!");
                return;
            }
            System.out.println("Correct!");
        }
        System.out.println("Congratulations, " + Cli.getUserName() + "!");
    }
}
