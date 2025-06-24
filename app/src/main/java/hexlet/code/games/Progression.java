package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_STEP = 10;
    private static final int MAX_START = 50;

    public static void run() {
        String[][] gameData = new String[Engine.ROUNDS_COUNT][2];
        Random random = new Random();

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int length = MIN_LENGTH + random.nextInt(MAX_LENGTH - MIN_LENGTH + 1);
            int start = random.nextInt(MAX_START) + 1;
            int step = random.nextInt(MAX_STEP) + 1;
            int hiddenIndex = random.nextInt(length);

            String[] progression = generateProgression(start, step, length, hiddenIndex);
            String question = String.join(" ", progression);
            int correctAnswer = start + hiddenIndex * step;

            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(correctAnswer);
        }

        String description = "What number is missing in the progression?";
        Engine.runGame(description, gameData);
    }

    private static String[] generateProgression(int start, int step, int length, int hiddenIndex) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            if (i == hiddenIndex) {
                progression[i] = "..";
            } else {
                progression[i] = String.valueOf(start + i * step);
            }
        }
        return progression;
    }
}
