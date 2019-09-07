
/*

Design a HashSet without using any built-in hash table libraries.
To be specific, your design should include these functions:
add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:
MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

*/

/*

O(1),O(n)

*/

class MyHashSet {
    private boolean[] buckets;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.buckets = new boolean[1000001];
    }
    
    public void add(int key) {
        buckets[key] = true;
    }
    
    public void remove(int key) {
        buckets[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return buckets[key];
    }
}




