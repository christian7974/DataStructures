package Hash_Table;

public class HashTable {
    int[] table;
    
    public HashTable(int size) {
        this.table = new int[size];
    }

    /**
     * Method to generate the hashed key to be used in the table (just mods the key by 10) (Terrible but simple
     * hashing algo)
     *
     * @param key the key that stores the value in the HashTable
     * @return the hashed key
     */
    public int getHash(int key) {
        return key % 10;
    }

    /**
     * Method that inserts a value into the HashTable for that key
     *
     * @param key the key in the HashTable
     * @param value the value to be stored at that key in the HashTable
     */
    public void set(int key, int value) {

    }

    /**
     * Method to get the value associated with that key
     *
     * @param key the key of the value the user wants to find
     * @return the value at that key in the HashTable
     */
    public int getValue(int key) {
        return 0;
    }

}
