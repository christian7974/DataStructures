import Hash_Table.HashTable;
import Linked_List.LinkedList;
import Stack_Queue_LL.Stack;
import Stack_Queue_LL.Queue;
import Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

import static Sorts.BubbleSort.bubbleSort;
import static Sorts.SelectionSort.selectionSort;
import static Sorts.InsertionSort.insertionSort;
import static Sorts.QuickSort.quickSort;
import static Sorts.MergeSort.mergeSort;
import static Sorts.RadixSort.radixSort;

public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList(1, 2, 3, 5);
    Stack stack1 = new Stack();
    Queue queue1 = new Queue();
    HashTable hashTable1 = new HashTable(20);
    BinarySearchTree tree = new BinarySearchTree();
    int[] array = {5, 8, 9, 3, 1};
    quickSort(array, 0, array.length - 1);
    ArrayList<Integer> list1 = new ArrayList<Integer>(List.of(170, 45, 75, 90, 802, 24, 2, 66, 11, 98));
    radixSort(list1);
    System.out.println(list1);
  }
}