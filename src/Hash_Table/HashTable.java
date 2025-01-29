package Hash_Table;
import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private List<List<String[]>> data;

    public HashTable(int size) {
        this.data = new ArrayList<>(size);
        for (int i = 0; i < size; i ++) {
            data.add(new ArrayList<>());
        }
    }

    public void printHashTable() {
        System.out.println("Hash Table Contents:");
        for (int i = 0; i < data.size(); i++) {
            List<String[]> bucket = data.get(i);
            System.out.print("Bucket " + i + ": ");
            if (bucket.isEmpty()) {
                System.out.print("Empty");
            } else {
                for (String[] pair : bucket) {
                    System.out.print("{" + pair[0] + ":" + pair[1] + "} ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Method to generate the hashed key to be used in the table (current algorithm can lead to collisions; can be
     * mitigated with a more advanced hashing algorithm)
     * Time Complexity: O(1)
     *
     * @param key the key that stores the value in the HashTable
     * @return the hashed key
     */
    public int getHash(String key) {
        int hash = 0;
        for (var i = 0; i < key.length(); i ++) {
            // generate a hash based on the letter's ASCII and the HashTable's length
            hash = (hash + key.charAt(i)) % this.data.size();
        }
        return hash;
    }

    /**
     * Method that inserts a value into the HashTable for that key
     * Time Complexity: O(1)
     *
     * @param key the key in the HashTable
     * @param value the value to be stored at that key in the HashTable
     */
    public void set(String key, int value) {
        int address = getHash(key); // generate a hash for that key
        List<String[]> bucket = data.get(address); // create a "bucket" for the key/value pair

        for (String[] pair : bucket) {
            if (pair[0].equals(key)) {
                pair[1] = Integer.toString(value);
                return;
            }
        }
        bucket.add(new String[] {key, Integer.toString(value)}); // add the key/value pair to the bucket
    }

    /**
     * Method to get the value associated with that key
     * Time Complexity: O(1)
     *
     * @param key the key of the value the user wants to find
     * @return the value at that key in the HashTable (or -1 if the key does not exist)
     */
    public int get(String key) {
       int address = getHash(key); // generate the hash from the key
       List<String[]> bucket = data.get(address); // generate a "bucket"
       if (bucket != null) {
           for (String[] pair: bucket) {
               // if the first thing in the "bucket" (the hashed key) matches the key being searched for
               if (pair[0].equals(key)) {
                   return Integer.parseInt(pair[1]); // return the value at that key
               }
           }
       }
       return -1; // returns -1 if the key does not exist within the HashTable
    }

}
