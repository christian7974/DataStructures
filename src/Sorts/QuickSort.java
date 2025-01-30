package Sorts;

public class QuickSort {

    /**
     * Helper method to QuickSort that splits the array into smaller sub-arrays
     * Time Complexity: O(n log(n)), worst case is O(n^2) if pivot is smallest/largest item in list
     *
     * @param arr the subarray that is to be sorted
     * @param low the low index (first element of that subarray)
     * @param high the high index (last element of subarray)
     * @return the pivot value after partitioning
     */
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // move pivot to the end
        int i = low - 1; // tracks last element that is less than or equal to pivot
        for (int j = low; j < high; j ++) {
            // if array value is less than/equal to pivot, swap values so all lesser values are before pivot
            if (arr[j] <= pivot) {
                i ++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap values to put pivot at the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // returns pivot element after partition
        return i + 1;
    }

    /**
     * QuickSort method (will call itself recursively until array is sorted)
     *
     * @param arr array to be sorted
     * @param low low index
     * @param high high index
     */
    public static void quickSort(int[] arr, int low, int high) {

        // if low > high, subarray is sorted, this does not run
        if (low < high) {
            int pivot_index = partition(arr, low, high);
            quickSort(arr, low, pivot_index - 1);
            quickSort(arr, pivot_index + 1, high);
        }
    }
}
