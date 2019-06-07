
/*

Design your implementation of the circular queue. 
The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle 
and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. 
In a normal queue, once the queue becomes full, we cannot insert the next element 
even if there is a space in front of the queue. 
But using the circular queue, we can use the space to store new values.

Your implementation should support following operations:
MyCircularQueue(k): Constructor, set the size of the queue to be k.
Front: Get the front item from the queue. If the queue is empty, return -1.
Rear: Get the last item from the queue. If the queue is empty, return -1.
enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
isEmpty(): Checks whether the circular queue is empty or not.
isFull(): Checks whether the circular queue is full or not.
 
Example:
MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
circularQueue.enQueue(1);  // return true
circularQueue.enQueue(2);  // return true
circularQueue.enQueue(3);  // return true
circularQueue.enQueue(4);  // return false, the queue is full
circularQueue.Rear();  // return 3
circularQueue.isFull();  // return true
circularQueue.deQueue();  // return true
circularQueue.enQueue(4);  // return true
circularQueue.Rear();  // return 4

*/

/*

O(1),O(n)

*/

class MyCircularQueue {
    private List<Integer> queue;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new LinkedList<>();
        this.size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (queue.size() < size) {
            queue.add(value);
            return true;
        }
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (queue.size() >= 1) {
            queue.remove(0);
            return true;
        }
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (queue.size() >= 1) {
            return queue.get(0);
        }
        return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (queue.size() >= 1) {
            return queue.get(queue.size() - 1);
        }
        return -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return queue.size() == size;
    }
}




