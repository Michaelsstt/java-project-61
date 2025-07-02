package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even {
    private static final int MAX_RANDOM_NUMBER = 100;

    private Even() {

    }


    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = Utils.generateNumber(0, MAX_RANDOM_NUMBER);
            String question = Integer.toString(number);
            String correctAnswer = isEven(number) ? "yes" : "no";

            gameData[i][0] = question;
            gameData[i][1] = correctAnswer;
        }
        Engine.runGame("Answer 'yes' if the number is even, otherwise answer 'no'.", gameData);

    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
