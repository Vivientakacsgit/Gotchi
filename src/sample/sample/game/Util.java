package sample.game;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static boolean doItOrDont(int chance) {
        int num = ThreadLocalRandom.current().nextInt(100);
        if (num > chance + 1) {
            return true;
        }
        return false;
    }


    public static String chooseAction() {

        int num = ThreadLocalRandom.current().nextInt(100);
        if (num < 33) {
            return "hungry";
        } else if (num > 33 && num < 66) {
            return "tired";
        } else {
            return "bored";
        }
    }
}
