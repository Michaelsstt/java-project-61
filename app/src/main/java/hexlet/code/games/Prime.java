package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int ROUNDS_COUNT = 3;

    public static void run() {
        String[][] gameData = generateGameData();
        Engine.runGame(DESCRIPTION, gameData);
    }

    private static String[][] generateGameData() {
        Random random = new Random();
        String[][] gameData = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = random.nextInt(100) + 2;
            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = isPrime(number) ? "yes" : "no";
        }

        return gameData;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
