package Linked_List;

public class LinkedList {
    Node head;
    int length = 0;
    /**
     * Constructor method of LinkedList class to accept 1 to n values
     *
     * @param values List of integers to be inserted into the LinkedList
     */
    public LinkedList(int... values) {
        this.head = new Node(values[0]);
        this.length = values.length;
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
     * Getter method to retrieve the length of the LL
     * @return the length of the LL
     */
    public int getLength() {
        return this.length;
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
     * Time Complexity: O(1)
     *
     * @param data integer to be added to the LinkedList
     */
    public void prepend(int data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = head; // set the new node's next to the head (put it before the head)
        head = newNode; // set the head to the new node
        this.length ++;
    }

    /**
     * Add a value to the end of the LinkedList
     * Time Complexity: O(n) but if there was a tail node, this would be O(1)
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
        this.length ++;
    }

    /**
     * Delete the first item in the LinkedList
     * Time Complexity: O(1)
     */
    public void deleteAtHead() {
        this.head = this.head.next;
        this.length --;
    }

    /**
     * Find a piece of data in the LinkedList and remove it
     * Time Complexity: O(n)
     *
     * @param target the value to find and delete in the LL
     * @return returns true if item found and deleted, false if otherwise
     */
    public boolean deleteValue(int target) {
        Node curr = this.head; // set pointer node to head
        while (curr.next != null) { // while the next node is not null
            if (curr.next.data == target) { // if the node after is the target value
                curr.next = curr.next.next; // set the next node to 2 nodes down
                this.length --;
                return true;
            }
            curr = curr.next; // iterate pointer node
        }
        return false;

    }

    /**
     * Delete the last item in the LinkedList (pop)
     * Time Complexity: O(n)
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
        this.length --;
    }

    /**
     * Search the LinkedList for an item
     * Time Complexity: O(n)
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

    /**
     * Function that reverses a LL using a 3-pointer approach
     * Set the node's next pointer to the node before it
     * Time Complexity: O(n)
     */
    public void reverse() {
        if (this.head == null) return;
        Node first = this.head; // previous Node
        Node second = first.next;
        while (second != null) {
            Node temp = second.next; // Temp helps us stay within the LL, moves to next node
            second.next = first; // set the pointer to the node prior
            first = second; // previous Node moves
            second = temp; // second node becomes the temp
        }
        this.head.next = null;
        this.head = first;
    }

    /**
     * Method to traverse to an index within the LL
     * Time Complexity: O(n)
     *
     * @param index the index to traverse to (0 based)
     * @return the Node located at that index
     */
    public Node traverseToIndex(int index) {
        if (index > length || index < 0) return null; // unable to iterate to node outside LL
        int counter = 0;
        Node currentNode = this.head;
        while (counter != index) {
            currentNode = currentNode.next;
            counter ++;
        }
        return currentNode;
    }

    /**
     * Inserts a Node at a certain index
     * Time Complexity: O(n)
     *
     * @param value the value of the Node to be inserted
     * @param index the index at which to insert the node at
     */
    public void insert(int value, int index) {
        if (index > length || index < 0) return; // return null if outside LL
        Node newNode = new Node(value);
        Node leader = traverseToIndex(index - 1); // the node before the index to be inserted
        Node holdingPointer = leader.next; // temp pointer (1 node after where the user wants to insert)
        // connect the newNode by setting the leader's next to the newNode, the newNode's next to the holding pointer
        leader.next = newNode;
        newNode.next = holdingPointer;
        this.length ++;
    }

    /**
     * Removes the Node at a given index
     * Time Complexity: O(n)
     */
    public void removeIndex(int index) {
        if (index >= length || index < 0) return;
        if (index == 0) { // if the index is the first one, set the head to the one after the head
            this.head = this.head.next;
            return;
        }
        // "skip" the node at the index you want to delete
        Node previousNode = traverseToIndex(index - 1);
        Node nodeToDelete = previousNode.next;
        // set the previousNode's next to the node after the node you want to delete (skip it)
        previousNode.next = nodeToDelete.next;
        length --;
    }


}
