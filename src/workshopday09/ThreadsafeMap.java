package workshopday09;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsafeMap {
    // Number of threads to simulate concurrent access
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        // Comparing HashMap (not thread-safe) and Hashtable (thread-safe)
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> hashTable = new Hashtable<>();

        System.out.println("Testing thread safety of HashMap (should fail):");
        testMapConcurrency(hashMap); // HashMap is not thread-safe, expect issues

        System.out.println("\nTesting thread safety of Hashtable (should succeed):");
        testMapConcurrency(hashTable); // Hashtable is thread-safe, expect no issues
    }

    // Method to test concurrent modifications on a given Map
    public static void testMapConcurrency(Map<String, String> map) {
        // Create a thread pool with NUM_THREADS threads
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        // Define a Runnable task that modifies the map
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                String threadName = Thread.currentThread().getName();
                map.put(threadName + "-" + i, "Value " + i);
            }
        };

        // Submit tasks to the executor service
        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.submit(task);
        }

        // Shutdown the executor service and wait for tasks to complete
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Waiting for all tasks to finish
        }

        // Print the final size of the map
        System.out.println("Final map size: " + map.size());
    }
}
