
/*

Design your implementation of the circular double-ended queue (deque).
Your implementation should support following operations:
MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not. 
isFull(): Checks whether Deque is full or not.
 
Example:
MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
circularDeque.insertLast(1);			// return true
circularDeque.insertLast(2);			// return true
circularDeque.insertFront(3);			// return true
circularDeque.insertFront(4);			// return false, the queue is full
circularDeque.getRear();  			// return 2
circularDeque.isFull();				// return true
circularDeque.deleteLast();			// return true
circularDeque.insertFront(4);			// return true
circularDeque.getFront();			// return 4

*/

/*

O(1),O(1)

*/

class MyCircularDeque {
    class Node {
        private Node prev;
        private Node next;
        private int val;
        
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size, cnt;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (head == null) {
            cnt++;
            head = new Node(value);
            tail = head;
            return true;
        } else if (cnt != size) {
            cnt++;
            Node node = new Node(value);
            node.next = head;
            head.prev = node;
            head = node;
            return true;
        }
        return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (head == null) {
            cnt++;
            head = new Node(value);
            tail = head;
            return true;
        } else if (cnt != size) {
            cnt++;
            Node node = new Node(value);
            node.prev = tail;
            tail.next = node;
            tail = node;
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (cnt == 0) {
            return false;
        } else if (cnt == 1) {
            cnt--;
            head = null;
            tail = null;
            return true;
        } else {
            cnt--;
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (cnt == 0) {
            return false;
        } else if (cnt == 1) {
            cnt--;
            head = null;
            tail = null;
            return true;
        } else {
            cnt--;
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : head.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : tail.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == null;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == cnt;
    }
}





