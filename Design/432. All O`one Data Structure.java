
/*

Implement a data structure supporting the following operations:
Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. 
           If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".

*/

/*

Solution: use a doubly linked node as a count bucket, for each key, add into the existing bucket or create a new bucket
O(1),O(n)

*/

class AllOne {
    
    class Node {
        private int cnt;
        private Set<String> keys;
        private Node prev, next;
        
        public Node(int cnt) {
            this.cnt = cnt;
            this.keys = new LinkedHashSet<>();
        }
        
        private void insert(Node node) {
            this.next = node;
            this.prev = node.prev;
            node.prev.next = this;
            node.prev = this;
        }
        
        private void remove(String key) {
            this.keys.remove(key);
            if (this.keys.isEmpty()) {
                this.prev.next = this.next;
                this.next.prev = this.prev;
            }
        }
    }
    
    private Node head, tail;
    private Map<String, Node> map;

    /** Initialize your data structure here. */
    public AllOne() {
        this.map = new HashMap<>();
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node cur = map.getOrDefault(key, head);
        Node nxt = cur.next;
        if (cur.cnt + 1 != nxt.cnt) {
            nxt = new Node(cur.cnt + 1);
            nxt.insert(cur.next);
        }
        nxt.keys.add(key);
        map.put(key, nxt);
        if (cur != head) cur.remove(key);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Node cur = map.get(key);
        if (cur == null) return;
        if (cur.cnt == 1) {
            map.remove(key);
            cur.remove(key);
            return;
        }
        Node prev = cur.prev;
        if (cur.cnt - 1 != prev.cnt) {
            prev = new Node(cur.cnt - 1);
            prev.insert(cur);
        }
        prev.keys.add(key);
        map.put(key, prev);
        cur.remove(key);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head.next == tail) return "";
        return tail.prev.keys.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }
}





