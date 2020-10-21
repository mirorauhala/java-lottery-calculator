
package dev.rauhala.util;
import java.io.Console;

/**
 * The MyConsole class contains methods for asdasd.
 *
 * @author Miro Rauhala
 */
public class MyConsole {
    /**
     *  Ask the user for an integer.
     *
     *  This method will ask the user for an integer continuously until one is given. You can pass a minimum and a
     *  maximum expected value. You can also define two error messages to be displayed in certain cases.
     *
     * @param min   int
     * @param max   int
     * @param errorMessageNonNumeric    String
     * @param errorMessageNonMinAndMax  String
     * @return int
     */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Console c = System.console();
        boolean validInput = false;
        int input = 0;

        do {
            System.out.println(errorMessageNonMinAndMax);
            try {
                input = Integer.parseInt(c.readLine());
                if(Math.between(input, min, max)) {
                    validInput = true;
                }
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
            }
        } while(!validInput);

        return input;
    }
}