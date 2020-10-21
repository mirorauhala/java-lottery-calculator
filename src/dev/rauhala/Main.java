
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

    public static void main(String [] args) {
        userLottery();
        iterateJackpot();
    }

    /**
     * Ask the user for the winning numbers.
     *
     * @return void
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
     * It will run until the lottery is won with the given "considerWinning" number.
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
     *
     * @return void
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
            // put random number into lotto array
            lotto[i] = numbers[index];

            // Remove the value with given index from the array.
            // numbers.length is now 39 instead of 40.
            numbers = Arrays.removeIndex(numbers, index);

            // get random index from the array, notice that now the numbers.length is one smaller
            index = Math.getRandom(0, numbers.length - 1);
            // .. and so on. Implement this using iteration (while)
        }

        return lotto;
    }
}