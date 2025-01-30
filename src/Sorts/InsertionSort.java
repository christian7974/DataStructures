package Sorts;

public class InsertionSort {
    /**
     * Method to sort an array by using Insertion Sort (moves the larger value left until it is in the correct spot)
     * Best to use when list is almost sorted or already sorted
     * Time Complexity: O(n^2) avg, best is O(n)
     *
     * @param list list of integers to be sorted
     */
    public static void insertionSort(int[] list) {
        for (var i = 0; i < list.length; i ++) {
            int key = list[i];
            int j = i - 1;
            // move elements of list[0..i-1] that are greater than key to one position to right of current position
            while (j >= 0 && key < list[j]) {
                list[j + 1] = list[j]; // shift larger elements to the right
                j--; // move j to the left
            }
            list[j + 1] = key; // put the key in the correct spot
        }
    }
}
