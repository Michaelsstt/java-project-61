package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int num1 = random.nextInt(100) + 1;
            int num2 = random.nextInt(100) + 1;
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
