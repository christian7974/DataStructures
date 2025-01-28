package Stack_Queue_LL;
import Linked_List.Node;

public class Queue {
    Node first;
    Node last;
    int length;

    public Queue() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    /**
     * Method that prints out the entire queue
     */
    public void printQueue() {
        Node temp = this.first;
        while (temp != null) {
            if (temp.next == null) {
                System.out.print(temp.data + "\n");
            } else {
                System.out.print(temp.data + " -> ");
            }
            temp = temp.next;
        }
    }

    /**
     * Adds a value to the end of the queue
     *
     * @param value the number to be inserted to the back of the queue
     */
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
        length ++;
    }

    /**
     * Remove the first thing in the queue
     */
    public void dequeue() {
        if (this.length == 0) {return;}
        if (this.length == 1) {this.first = null;}
        Node temp = this.first;
        this.first = this.first.next;
        length --;
    }

    /**
     * Look at the value that is first in the queue
     *
     * @return the first Node in the queue
     */
    public Node peek() {
        return this.first;
    }
}
