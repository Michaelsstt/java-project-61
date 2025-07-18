package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;


public class GCD {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num1 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);
            int num2 = Utils.generateNumber(MIN_NUMBER, MAX_NUMBER);
            int correctAnswer = calculateGCD(num1, num2);

            gameData[i][0] = num1 + " " + num2;
            gameData[i][1] = String.valueOf(correctAnswer);
        }

        String description = "Find the greatest common divisor of given numbers.";
        Engine.runGame(description, gameData);
    }

    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
