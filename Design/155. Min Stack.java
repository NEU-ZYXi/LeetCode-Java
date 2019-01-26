
/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

*/

/*

Solution 1: when we have a new minimum value, push the previous min value to the stack, then update min and push it to stack
            when we pop the current min value, the next poped one is the new min which is the previous min
O(1),O(n)

*/

class MinStack {
    
    private Deque<Integer> deque;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        this.deque = new LinkedList<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min) {
            deque.offerLast(min);
            min = x;
        }
        deque.offerLast(x);
    }
    
    public void pop() {
        if (min == deque.pollLast()) min = deque.pollLast();
    }
    
    public int top() {
        return deque.peekLast();
    }
    
    public int getMin() {
        return min;
    }
}


/*

Solution 2: use a Node class to simulate stack, keep track of the min value until the current node
O(1),O(n)

*/

class MinStack {

    class Node {
        int val, min;
        Node next;
        
        public Node(int _val, int _min, Node _next) {
            this.val = _val;
            this.min = _min;
            this.next = _next;
        }
    }
    
    private Node head;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.head = null;    
    }
    
    public void push(int x) {
        if (head == null) head = new Node(x, x, null);
        else head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}




