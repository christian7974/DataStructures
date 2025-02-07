package Sorts;

import java.util.ArrayList;
import java.util.Collections;

public class RadixSort {

    /**
     * Method that implements RadixSort, a non-comparison sort that groups each numbers per digit
     * Time Complexity: O(n * k) where n is the number of elements and k is the number of digits in the highest value
     * Worst case is O(N^2), where k is equal to n; works best when k is a lot smaller than n
     *
     * @param array array to be sorted
     */
    public static void radixSort(ArrayList<Integer> array) {
        int maxVal = Collections.max(array); // finds largest value in array, need to find how many digits we need
        int exp = 1; // current digit to look at (starts at ones)

        while (maxVal / exp > 0) { // while the largest number still has digits to process (floor division)
            ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<>());
            }

            // Distribute elements to buckets
            for (int val : array) {
                int radixIndex = (val / exp) % 10; // get the digit at the current place
                buckets.get(radixIndex).add(val); // place the number in the correct bucket
            }

            // Clear the original array
            array.clear();

            // get value from current bucket, add it to the array
            for (ArrayList<Integer> bucket : buckets) {
                array.addAll(bucket);
            }

            exp *= 10; // move on to the next digit (ones -> tens -> hundreds)
        }
    }

}
