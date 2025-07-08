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

            int[] progression = generateProgression(start, step, length);
            String question = createQuestion(progression, hiddenIndex);
            int correctAnswer = progression[hiddenIndex];

            gameData[i][0] = question;
            gameData[i][1] = String.valueOf(correctAnswer);
        }

        String description = "What number is missing in the progression?";
        Engine.runGame(description, gameData);
    }

    private static int[] generateProgression(int start, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }

    private static String createQuestion(int[] progression, int hiddenIndex) {
        String[] questionElements = new String[progression.length];
        for (int i = 0; i < progression.length; i++) {
            questionElements[i] = (i == hiddenIndex) ? ".." : String.valueOf(progression[i]);
        }
        return String.join(" ", questionElements);
    }
}
