package hexlet.code;

import java.util.Random;

public class Calc {
    private static final Random RANDOM = new Random();
    private static final char[] OPERATORS = {'+', '-', '*'};

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num1 = RANDOM.nextInt(100);
            int num2 = RANDOM.nextInt(100);

            char operator = OPERATORS[RANDOM.nextInt(OPERATORS.length)];

            String question = num1 + " " + operator + " " + num2;
            String correctAnswer = calculate(num1, num2, operator);

            gameData[i][0] = question;
            gameData[i][1] = correctAnswer;
        }
        Engine.runGame("What is the result of expression?", gameData);
    }

    private static String calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> String.valueOf(num1 + num2);
            case '-' -> String.valueOf(num1 - num2);
            case '*' -> String.valueOf(num1 * num2);
            default -> throw new RuntimeException("Unknown operator: " + operator);
        };
    }
}
