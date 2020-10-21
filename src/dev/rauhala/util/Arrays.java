
package dev.rauhala.util;
/**
 * The Arrays class contains methods for operating with arrays.
 *
 * @author Miro Rauhala
 */
public class Arrays {

    /**
     * Transform a string array to an integer array.
     *
     * @param old   The array to be transformed.
     * @return int array
     */
    public static int[] toIntArray(String[] old) {
        int newArray[] = new int[old.length];

        for (int i = 0; i < old.length; i++) {
            newArray[i] = Integer.parseInt(old[i]);
        }

        return newArray;
    }

    /**
     * Checks if the needle is found in the haystack.
     *
     * This method counts the values inside the haystack array that match the value of the needle integer.
     * It returns a boolean value.
     *
     * @param needle   The integer type of a needle.
     * @param haystack The integer type of a haystack.
     * @return boolean
     */
    public static boolean contains(int needle, int[] haystack) {
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if the needle is found in the haystack.
     *
     * This method counts the values inside the haystack array that match the values inside the needle array.
     * It returns an integer value representing the amount of the same values.
     *
     * @param needle   The integer array type of a needle.
     * @param haystack The integer array type of a haystack.
     * @return int amount of the same values.
     */
    public static int containsSameValues(int[] needle, int[] haystack) {
        int count = 0;
        for (int i = 0; i < needle.length; i++) {
            for (int j = 0; j < haystack.length; j++) {
                if (haystack[j] == needle[i]) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Removes an index from the given array.
     *
     * @param original The integer array type of a needle.
     * @param index    The integer array type of a haystack.
     * @return int array
     */
    public static int[] removeIndex(int[] original, int index) {

        if (original.length - 1 < 0) {
            return new int[0];
        }

        int[] newArray = new int[original.length - 1];

        for (int i = 0, k = 0; i < original.length; i++) {

            if (i == index) {
                continue;
            }

            newArray[k++] = original[i];
        }

        return newArray;

    }

    /**
     * Sorts the given array using selection sort.
     *
     * Selection sort algorithm results in an array that starts from the smallest to the biggest.
     *
     * @param sortable An array to be sorted.
     * @return int array
     */
    public static int[] sort(int[] sortable) {
        for (int i = 0; i < sortable.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < sortable.length - 1; j++) {
                if (sortable[j] < sortable[index]) {
                    index = j;
                }
            }

            // swap
            int temp = sortable[index];
            sortable[index] = sortable[i];
            sortable[i] = temp;
        }

        return sortable;
    }

}