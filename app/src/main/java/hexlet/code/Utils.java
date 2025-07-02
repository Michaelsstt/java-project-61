package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();

    public static int generateNumber(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }
}
