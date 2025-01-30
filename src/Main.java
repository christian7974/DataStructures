import Hash_Table.HashTable;
import Linked_List.LinkedList;
import Stack_Queue_LL.Stack;
import Stack_Queue_LL.Queue;
import Trees.BinarySearchTree;
import Sorts.BubbleSort;

import java.util.ArrayList;

import static Sorts.BubbleSort.bubbleSort;
import static Sorts.SelectionSort.selectionSort;
import static Sorts.InsertionSort.insertionSort;
import static Sorts.QuickSort.quickSort;

public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList(1, 2, 3, 5);
    Stack stack1 = new Stack();
    Queue queue1 = new Queue();
    HashTable hashTable1 = new HashTable(20);
    BinarySearchTree tree = new BinarySearchTree();
    int[] array = {5, 8, 9, 3, 1};
    quickSort(array, 0, array.length - 1);
  }
}