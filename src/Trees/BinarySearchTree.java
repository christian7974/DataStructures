package Trees;


public class BinarySearchTree {
    TNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * Method to insert a node into a Binary Search Tree
     * Time Complexity: O(log(n))
     *
     * @param value the value to be inserted into the BST
     */
    public void insert(int value) {
        TNode newNode = new TNode(value);
        if (this.root == null) this.root = newNode; // if the root is null, then set the root to the new node
        else {
            TNode currentNode = this.root;
            while (true) {
                if (currentNode.value > value) { // if the currentValue > value, then go left
                    if (currentNode.left == null) { // if there is no left, then put the node there
                        currentNode.left = newNode;
                        break;
                    }
                    currentNode = currentNode.left; // continue left
                } else { // else, then go right
                    if (currentNode.right == null) { // if there is no right, then put node there
                        currentNode.right = newNode;
                        break;
                    }
                    currentNode = currentNode.right; // continue right
                }
            }
        }
    };

    /**
     * Method to look up a value in the BST
     * Time Complexity: O(log(n))
     *
     * @param value the value to be searched for
     * @return the value if it exists or null if it does not exist
     */
    public Integer lookup(int value) {
        if (this.root == null) return null;
        TNode currentNode = this.root; // the node used to traverse the tree
        while (currentNode != null) {
            if (value < currentNode.value) { // if the value is less than the currentNode's value, go left
                currentNode = currentNode.left;
            } else if (value > currentNode.value) { // if the value is greater than the currentNode's value, go right
                currentNode = currentNode.right;
            } else {
                return currentNode.value; // if the values are equal, then return the number at that currentNode
            }
        }
        return null;
    };

    /**
     * Method to remove a node from the BST
     * Time Complexity: O(log(n))
     *
     * @param value value to remove from the BST
     * @return boolean value, false if the node could not be removed, true if it was found and removed
     */
    public boolean delete(int value) {
        if (this.root == null) return false;
        TNode nodeToDelete = this.root;
        TNode parentNode = null;
        while (nodeToDelete != null) {
            // 1. find the node that we want to delete
            if (value < nodeToDelete.value) { // move left
                parentNode = nodeToDelete;
                nodeToDelete = nodeToDelete.left;
            } else if (value > nodeToDelete.value) { // move right
                parentNode = nodeToDelete;
                nodeToDelete = nodeToDelete.right;
            }
            // found the node that we want to delete
            else {
                // option 1: no right child
                if (nodeToDelete.right == null) {
                    if (parentNode == null) {
                        this.root = nodeToDelete.left;
                    } else {
                        // if the node to delete is a left child, make parent's left point to the NTD's left
                        if (parentNode.value > nodeToDelete.value) {
                            parentNode.left = nodeToDelete.left;
                        // else, make parent's right point to the NTD's left
                        } else {
                            parentNode.right = nodeToDelete.left;
                        }
                    }
                // option 2: right child does not have a left child, promote the right child to take deleted node's place
                } else if (nodeToDelete.right.left == null) {
                    nodeToDelete.right.left = nodeToDelete.left;
                    if (parentNode == null) {
                        this.root = nodeToDelete.right;
                        // if parent > current, make right child of the left the parent
                    } else {
                        if (nodeToDelete.value < parentNode.value) {
                            parentNode.left = nodeToDelete.right;
                        // else, make right child a right child of the parent
                        } else {
                            parentNode.right = nodeToDelete.right;
                        }
                    }
                // option 3: right child that has a left child
                } else {
                    // find the right child's left most child (leftmost node in right subtree)
                    TNode leftMost = nodeToDelete.right.left;
                    TNode leftMostParent = nodeToDelete.right;
                    while (leftMost.left != null) {
                        leftMostParent = leftMost;
                        leftMost = leftMost.left;
                    }
                    // leftmost node might have right child, so attach it to leftMostParent's left (prevents breaking tree)
                    leftMostParent.left = leftMost.right;

                    // leftmost node takes place of deleteNode
                    // deleted nodes left and right children are reassigned to the leftmost node
                    // update parent's pointer to point to leftMost
                    leftMost.left = nodeToDelete.left;
                    leftMost.right = nodeToDelete.right;
                    if (parentNode == null) {
                        this.root = leftMost;
                    } else {
                        if (nodeToDelete.value < parentNode.value) {
                            parentNode.left = leftMost;
                        } else {
                            parentNode.right = leftMost;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Method to get the root of the tree
     *
     * @return the root of the tree as a TNode
     */
    public TNode getRoot() {
        return this.root;
    }
}
