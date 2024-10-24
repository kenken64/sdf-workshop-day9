package workshopday09;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * As you can see, HashMap is usually faster because it is not synchronized, 
 * while Hashtable has extra overhead due to synchronization.
 */
public class MapComparison {
     public static void main(String[] args) {
        // Creating a HashMap
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "Apple");
        hashMap.put("2", "Banana");
        hashMap.put("3", "Orange");
        hashMap.put(null, "Grapes"); // HashMap allows null keys
        hashMap.put("4", null);      // HashMap allows null values
        
        System.out.println("HashMap:");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Creating a Hashtable
        Map<String, String> hashTable = new Hashtable<>();
        hashTable.put("1", "Apple");
        hashTable.put("2", "Banana");
        hashTable.put("3", "Orange");
        // hashTable.put(null, "Grapes"); // Hashtable does not allow null keys
        // hashTable.put("4", null);      // Hashtable does not allow null values, will throw NullPointerException
        
        System.out.println("\nHashtable:");
        for (Map.Entry<String, String> entry : hashTable.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        
        // Performance Difference Example for HashMap
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashMap.put("Key" + i, "Value" + i);
        }
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;
        double durationInMs = durationInNs / 1_000_000.0;
        double durationInSec = durationInNs / 1_000_000_000.0;
        System.out.println("\nHashMap Insertion Time: " + durationInNs + " ns");
        System.out.println("HashMap Insertion Time: " + durationInMs + " ms");
        System.out.println("HashMap Insertion Time: " + durationInSec + " s");

        // Performance Difference Example for Hashtable
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashTable.put("Key" + i, "Value" + i);
        }
        endTime = System.nanoTime();
        durationInNs = endTime - startTime;
        durationInMs = durationInNs / 1_000_000.0;
        durationInSec = durationInNs / 1_000_000_000.0;
        System.out.println("\nHashtable Insertion Time: " + durationInNs + " ns");
        System.out.println("Hashtable Insertion Time: " + durationInMs + " ms");
        System.out.println("Hashtable Insertion Time: " + durationInSec + " s");
    }
}
