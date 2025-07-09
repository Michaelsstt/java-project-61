package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;


public class Progression {
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_STEP = 10;
    private static final int MAX_START = 50;

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int length = Utils.generateNumber(MIN_LENGTH, MAX_LENGTH);
            int start = Utils.generateNumber(1, MAX_START);
            int step = Utils.generateNumber(1, MAX_STEP);
            int hiddenIndex = Utils.generateNumber(0, length - 1);

            String[] progression = generateProgression(start, step, length);
            String answer = progression[hiddenIndex];  // Сохраняем правильный ответ
            progression[hiddenIndex] = "..";

            gameData[i][0] = String.join(" ", progression);  // Вопрос - прогрессия с ".."
            gameData[i][1] = answer;
        }

        String description = "What number is missing in the progression?";
        Engine.runGame(description, gameData);
    }

    private static String[] generateProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }
}
