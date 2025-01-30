package Sorts;

public class SelectionSort {
    /**
     * Selection Sort method; works by swapping the smallest value in the sublist with value at beginning of list
     * Time Complexity: O(n^2)
     *
     * @param list the list to be sorted
     */
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i ++) {
            int currentMin = i; // used to find the smallest value in sublist
            int temp = list[i];
            for (int j = i + 1; j < list.length; j ++) {
                if (list[j] < list[currentMin]) {
                    currentMin = j; // find the smallest value in list
                }
            }
            // swap the smallest value in sublist (j/inner loop) with value at the beginning of the list (i/outer loop)
            list[i] = list[currentMin];
            list[currentMin] = temp;
        }
    }
}
