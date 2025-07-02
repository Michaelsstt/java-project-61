package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_PRIME_NUMBER = 2;

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = Utils.generateNumber(MIN_PRIME_NUMBER, MAX_RANDOM_NUMBER);
            gameData[i][0] = String.valueOf(number);
            gameData[i][1] = isPrime(number) ? "yes" : "no";
        }
        Engine.runGame(DESCRIPTION, gameData);
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
