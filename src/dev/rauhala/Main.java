
package dev.rauhala;

import dev.rauhala.util.Math;
import dev.rauhala.util.MyConsole;
import dev.rauhala.util.Arrays;
import java.io.Console;

/**
 * This class is the entrypoint to the lottery app.
 *
 * @author Miro Rauhala
 */
public class Main {
    final static int LOTTERY_START = 1;
    final static int LOTTERY_END = 40;
    final static int LOTTERY_JACKPOT = 7;
    final static String LOTTERY_GUIDE = "Please give a unique number between ["+LOTTERY_START+", "+LOTTERY_END+"]";
    final static String LOTTERY_NUMERICAL_ERROR = "Please give a number.";
    final static String LOTTERY_MINMAX_ERROR = LOTTERY_GUIDE;
    static int[] USER_LOTTERY = new int[LOTTERY_JACKPOT];


    /**
     * This is the method to run the rest of the lottery app.
     * @param args
     */
    public static void main(String [] args) {
        userLottery();
        iterateJackpot();
    }

    /**
     * Ask the user for the winning numbers.
     */
    public static void userLottery() {
        for (int i = 0; i < LOTTERY_JACKPOT;) {

            int guess = MyConsole.readInt(LOTTERY_START, LOTTERY_END, LOTTERY_NUMERICAL_ERROR, LOTTERY_MINMAX_ERROR);

            if(Arrays.contains(guess, USER_LOTTERY)) {
                System.out.println("Not unique numbers!");
            } else {
                USER_LOTTERY[i] = guess;
                i++;
            }
        }
    }

    /**
     * Runs the lottery until the user has won.
     *
     * It will run until the lottery is won with the given "considerWinning" number. In the end the method
     * will return the amount of years it took to win.
     *
     * @param considerWinning   An integer to calculate winning against.
     * @return int              The amount of years it took to win.
     */
    private static int iteration(int considerWinning) {
        boolean won = false;
        int weeks = 0;
        while(won == false) {
            int winning[] = calculateLotto();
            int collision = Arrays.containsSameValues(USER_LOTTERY, winning);
            weeks++;
            if(collision == considerWinning) {

                if(weeks < 52) {
                    System.out.println("Got "+ collision+" right. Took "+ weeks + " weeks.");
                } else {
                    System.out.println("Got "+ collision+" right. Took "+ weeks/52 + " years.");
                }

                won = true;
            }
        }

        return (int) weeks / 52;

    }

    /**
     * Iterate the jackpots.
     *
     * This will iterate the amount of jackpots that have been set. For each jackpot, it will
     * count the amount of time it took to win.
     */
    public static void iterateJackpot() {
        for (int i = 0; i < LOTTERY_JACKPOT; i++) {
            int years = iteration(i+1);

            if(i+1 == LOTTERY_JACKPOT && years > 120) {
                System.out.println("You won!");
                System.out.println("Althought it took more than a lifetime, let's try it again.");
                i = -1;
            } else if(i+1 == LOTTERY_JACKPOT && years < 120) {
                System.out.println("You wont the jackpot in under 120 years.");
            }
        }
    }

    /**
     * Generate the random winning lottery numbers.
     *
     * It generates the possible numbers into an array "numbers" and from there it randomly picks a random number
     * to the "lotto" array. After that the chosen number is removed from the original "numbers" array, therefore
     * only allowing unique numbers to be chosen.
     *
     * @return array    Return an array with winning lottery numbers.
     */
    private static int[] calculateLotto() {
        int [] lotto = new int[LOTTERY_JACKPOT];
        int [] numbers = new int[LOTTERY_END];

        for (int i = 0; i < LOTTERY_END; i++) {
            numbers[i] = i;
        }

        int index = Math.getRandom(0, numbers.length - 1);

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = numbers[index];

            numbers = Arrays.removeIndex(numbers, index);

            index = Math.getRandom(0, numbers.length - 1);
        }

        return lotto;
    }
}