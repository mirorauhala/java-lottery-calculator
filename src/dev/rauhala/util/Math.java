
package dev.rauhala.util;

/**
 * The Math class contains methods for basic mathematical operations.
 *
 * @author Miro Rauhala
 */
public class Math {
    /**
     * Returns a random integer.
     *
     * Two arguments can be passed, a min and a max.
     *
     * @param min   The minimum the result can be.
     * @param max   The maximum the result can be.
     * @return int
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }

    /**
     * Check if an integer is between two integers.
     *
     * @param value int     The integer to be compared.
     * @param min int       The start of the comparison range.
     * @param max int       The end of the comparison range.
     * @return boolean
     */
    public static boolean between(int value, int min, int max) {
        return value >= min && value <= max;
    }
}