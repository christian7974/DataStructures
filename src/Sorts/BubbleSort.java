package Sorts;

public class BubbleSort {

    /**
     * Method to implement Bubble Sort (bubbles the largest value to the end of the array)
     * Time Complexity: O(n^2)
     *
     * @param list the list to be sorted
     */
    public static void bubbleSort(int[] list) {
        for (var i = 0; i < list.length - 1; i ++) {
            for (var j = 0; j < list.length - 1; j ++) {

                // if the previous element is larger than the next one, swap them until largest # is at end of array
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}
