
/*

Design a HashMap without using any built-in hash table libraries.
To be specific, your design should include these functions:
put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

*/

/*

Solution: listnode and buckets, find hashcode index of bucket for each key
O(1),O(n)

*/

class MyHashMap {
    class ListNode {
        private int key, val;
        private ListNode next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    class Bucket {
        private ListNode head;
        
        public Bucket() {
            this.head = new ListNode(-1, -1);
        }
    }
    
    private Bucket[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.buckets = new Bucket[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = getIndex(key);
        if (buckets[i] == null) {
            buckets[i] = new Bucket();
        }
        ListNode prev = findPrev(buckets[i], key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = getIndex(key);
        if (buckets[i] == null) {
            return -1;
        }
        ListNode prev = findPrev(buckets[i], key);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = getIndex(key);
        if (buckets[i] == null) {
            return;
        }
        ListNode prev = findPrev(buckets[i], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }
    
    private int getIndex(int key) {
        return Integer.hashCode(key) % buckets.length;
    }
    
    private ListNode findPrev(Bucket bucket, int key) {
        ListNode cur = bucket.head, prev = null;
        while (cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
}





