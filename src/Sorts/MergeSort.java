package Sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    /**
     * Method that performs MergeSort on an ArrayList
     * Time Complexity: O(n log(n))
     *
     * @param list the list to be sorted
     * @return recursive call that actually sorts the array
     */
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(list.subList(0, mid)); // left copy of sublist
        ArrayList<Integer> right = new ArrayList<>(list.subList(mid, list.size())); // right copy of sublist

        ArrayList<Integer> sortedLeft = mergeSort(left); // sort the left half
        ArrayList<Integer> sortedRight = mergeSort(right); // sort the right half
        return merge(sortedLeft, sortedRight); // combines two sorted halves into one array
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()) { // as long as there are elements in both subarrays
            if (left.get(i) <= right.get(j)) { // if the element on the left is smaller, add it to the results array
                result.add(left.get(i));
                i ++;
            } else { // if the element on the right is smaller, add it to the results array
                result.add(right.get(j));
                j++;
            }
        }
        result.addAll(left.subList(i, left.size())); // adds whatever remains of the left sublist to the results
        result.addAll(right.subList(j, right.size())); // adds whatever remains of the right sublist to the results
        return result;
    }
}
