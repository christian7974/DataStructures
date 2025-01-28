import Linked_List.LinkedList;
import Stack_Queue_LL.Stack;
import Stack_Queue_LL.Queue;

public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList(1, 2, 3, 5);
    Stack stack1 = new Stack();
    Queue queue1 = new Queue();
    queue1.enqueue(1);
    queue1.enqueue(2);
    queue1.dequeue();
    System.out.println(queue1.peek().data + " is the first value in the queue");
    queue1.printQueue();
  }
}