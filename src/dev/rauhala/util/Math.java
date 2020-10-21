
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
     * @return int, random.
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }

    /**
     * Check if an integer is between two integers.
     *
     * @param value int
     * @param min int
     * @param max int
     * @return boolean
     */
    public static boolean between(int value, int min, int max) {
        return value >= min && value <= max;
    }
}