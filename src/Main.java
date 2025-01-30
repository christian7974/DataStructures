import Hash_Table.HashTable;
import Linked_List.LinkedList;
import Stack_Queue_LL.Stack;
import Stack_Queue_LL.Queue;
import Trees.BinarySearchTree;
import Sorts.BubbleSort;

import java.util.ArrayList;

import static Sorts.BubbleSort.bubbleSort;
import static Sorts.SelectionSort.selectionSort;

public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList(1, 2, 3, 5);
    Stack stack1 = new Stack();
    Queue queue1 = new Queue();
    HashTable hashTable1 = new HashTable(20);
    BinarySearchTree tree = new BinarySearchTree();
    int[] list1 = {2, 5, 3, 1, 4};
    selectionSort(list1);
    for (int i : list1) {
      System.out.print(i + " ");
    }
  }
}