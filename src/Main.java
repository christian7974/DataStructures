import Hash_Table.HashTable;
import Linked_List.LinkedList;
import Stack_Queue_LL.Stack;
import Stack_Queue_LL.Queue;
import Trees.BinarySearchTree;
import Trees.TNode;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList(1, 2, 3, 5);
    Stack stack1 = new Stack();
    Queue queue1 = new Queue();
    HashTable hashTable1 = new HashTable(20);
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(5);
    tree.insert(8);
    tree.insert(3);
    tree.insert(2);
    tree.insert(4);
    tree.insert(7);
    ArrayList<TNode> nodesList = tree.DFSPostOrder();
    for (TNode node : nodesList) {
      System.out.println(node.value);
    }

  }
}