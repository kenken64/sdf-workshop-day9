## Csv Parser

https://github.com/datablist/sample-csv-files?tab=readme-ov-file



Map Initialization:

hashMap: A regular HashMap, which is not thread-safe.
hashTable: A Hashtable, which is synchronized and thread-safe.
Thread Pool:

ExecutorService is used to create a pool of threads (NUM_THREADS = 10), simulating concurrent access.
Task Definition:

Each thread runs the same task: it performs 1,000 put operations into the map, using the thread name and an index to create keys (threadName + "-" + i).
This creates a potential race condition in HashMap.
Concurrency Test:

For both HashMap and Hashtable, 10 threads are spawned, each performing 1,000 put operations.
The expected behavior is that HashMap will exhibit issues (inconsistent final map size, possibly throwing ConcurrentModificationException), while Hashtable will handle the concurrent access safely.
Output:

After all threads complete, the final size of the map is printed. If HashMap has issues, the final size will likely be incorrect. However, Hashtable should show the expected number of entries (10 * 1000 = 10,000).
