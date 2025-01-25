package Linked_List;

public class LinkedList {
    Node head;

    /**
     * Constructor method of LinkedList class to accept 1 to n values
     *
     * @param values List of integers to be inserted into the LinkedList
     */
    public LinkedList(int... values) {
        this.head = new Node(values[0]);
        Node curr = this.head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new Node(values[i]);
            curr = curr.next;
        }
    }

    /**
     * Constructor method of LinkedList class that accepts no values (creates an empty LinkedList)
     */
    public LinkedList() {
        this.head = null;
    }


    /**
     * Display the LinkedList, separated by ->
     */
    public void printList() {
        Node currNode = this.head;
        while (currNode != null) {
            if (currNode.next == null) {
                System.out.print(currNode.data + "\n");
            } else {
                System.out.print(currNode.data + " -> ");
            }
            currNode = currNode.next;
        }

    }

    /**
     * Add an integer to the beginning of the LinkedList
     *
     * @param data integer to be added to the LinkedList
     */
    public void prepend(int data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = head; // set the new node's next to the head (put it before the head)
        head = newNode; // set the head to the new node
    }

    /**
     * Add a value to the end of the LinkedList
     *
     * @param data integer to be added to the end of the LinkedList
     */
    public void push(int data) {
        Node newNode = new Node(data);
        if (this.head == null) { // if the LinkedList is empty, set the head to the newNode
            this.head = newNode;
            return;
        }
        Node curr = this.head;
        while (curr.next != null) { // while the next node is not null (null is the end of the LL)
            curr = curr.next; // move on to the next node until the end
        }
        curr.next = newNode; // the last node is the new node
    }

    /**
     * Delete the first item in the LinkedList
     */
    public void deleteAtHead() {
        this.head = this.head.next;
    }

    /**
     * Find a piece of data in the LinkedList and remove it
     *
     * @param target the value to find and delete in the LL
     * @return returns true if item found and deleted, false if otherwise
     */
    public boolean deleteValue(int target) {
        Node curr = this.head; // set pointer node to head
        while (curr.next != null) { // while the next node is not null
            if (curr.next.data == target) { // if the node after is the target value
                curr.next = curr.next.next; // set the next node to 2 nodes down
                return true;
            }
            curr = curr.next; // iterate pointer node
        }
        return false;

    }

    /**
     * Delete the last item in the LinkedList (pop)
     */
    public void pop() {

        if (this.head == null) return; // if the LL is empty, exit

        if (this.head.next == null) { // if the LL only has one node, set the head to null
            this.head = null;
            return;
        }

        Node currNode = this.head.next; // start pointer at the one after the head
        while (currNode.next.next != null) { // while the node after the pointer is not null
            currNode = currNode.next; // move the current node
        }
        currNode.next = null; // when the currentNode is one behind the last element, set its next to null
    }

    /**
     * Search the LinkedList for an item
     *
     * @param target integer to search for in the LinkedList
     * @return boolean to show if the integer exists in the Linked List
     */
    public boolean search(int target) {
        if (this.head == null) return false; // if the LL is empty, return false
        Node currNode = this.head;
        while (currNode != null) { // while the current node (pointer) is not null (exists)
            if (currNode.data == target) { // if the pointer's data matches target, return true
                return true;
            }
            currNode = currNode.next; // move on to the next node
        }
        return false;
    }
}
