package Stack_Queue_LL;

import Linked_List.Node;

public class Stack {

    int length;
    Node top;
    Node bottom = null;

    public Stack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    /**
     * Method that prints out the Stack, starting at the top
     */
    public void printStack() {
        Node currNode = this.top;
        while (currNode != null) {
            if (currNode == this.top) { // currNode is the top of the stack
                System.out.println(currNode.data + " <- Top of stack");
            } else if (currNode.next == null) { // currNode is the bottom of the stack
                System.out.print(currNode.data + "\n");
                return;
            } else { //
                System.out.println(currNode.data);

            }
            System.out.println("--------");
            currNode = currNode.next;
        }
    }

    public int getLength() {
        return this.length;
    }

    /**
     * Method that returns the Node at the top of the stack
     * Time Complexity: O(1)
     *
     * @return the top of the Stack
     */
    public Node peek() {
        return this.top;
    }

    /**
     * Add a new Node to the top of the Stack
     * Time Complexity: O(1)
     *
     * @param value the value to be inserted at the top of the stack
     */
    public void push(int value) {
        Node newNode = new Node(value); // create new node
        if (length == 0) { // if the length is 0 (empty stack), set top and bottom to new node
            this.top = newNode;
            this.bottom = newNode;
        } else {
            Node temp = this.top; // set a temp node to the top
            this.top = newNode; // the top is the new node
            this.top.next = temp; // connect the top to the temp node (connect the stack)
        }
        length++;
    }

    /**
     * Remove the top of the Stack
     * Time Complexity: O(1)
     */
    public void pop() {
        if (this.length == 0) return;
        if (this.top == this.bottom) this.bottom = null;
        // set the top to the node that is below the top (the second from the top is the new top)
        this.top = this.top.next;
        length--;

    }
}
