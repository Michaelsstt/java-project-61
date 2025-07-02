package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final char[] OPERATORS = {'+', '-', '*'};
    private static final int MAX_OPERAND_VALUE = 100;

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num1 = Utils.generateNumber(0, MAX_OPERAND_VALUE);
            int num2 = Utils.generateNumber(0, MAX_OPERAND_VALUE);

            char operator = OPERATORS[Utils.generateNumber(0, OPERATORS.length - 1)];

            String question = num1 + " " + operator + " " + num2;
            String correctAnswer = calculate(num1, num2, operator);

            gameData[i][0] = question;
            gameData[i][1] = correctAnswer;
        }
        Engine.runGame("What is the result of the expression?", gameData);
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
