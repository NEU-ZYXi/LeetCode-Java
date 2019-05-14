
/*

Design and implement a data structure for Least Frequently Used (LFU) cache. 
It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. 
When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. 
For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), 
the least recently used key would be evicted.

Example:
LFUCache cache = new LFUCache( 2 /* capacity */ );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/

/*

O(1),O(n)

*/

class LFUCache {
    
    private Map<Integer, Integer> cache;
    private Map<Integer, Integer> counts;
    private Map<Integer, Set<Integer>> map;
    private int capacity;
    private int min;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.counts = new HashMap<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.min = -1;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        countOne(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            cache.put(key, value);
            countOne(key);
        } else {
            if (cache.size() >= capacity) {
                int lfuItem = map.get(min).iterator().next();
                map.get(min).remove(lfuItem);
                cache.remove(lfuItem);
            }
            cache.put(key, value);
            counts.put(key, 1);
            min = 1;
            map.putIfAbsent(1, new LinkedHashSet<>());
            map.get(1).add(key);
        }
    }
    
    private void countOne(int key) {
        int cnt = counts.get(key);
        counts.put(key, cnt + 1);
        map.get(cnt).remove(key);
        if (cnt == min && map.get(cnt).size() == 0) min++;
        map.putIfAbsent(cnt + 1, new LinkedHashSet<>());
        map.get(cnt + 1).add(key);
    }
}





