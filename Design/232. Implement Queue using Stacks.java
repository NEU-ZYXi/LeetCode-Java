
/*

mplement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Example:
MyStack stack = new MyStack();
stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false

*/

/*

Solution 1: use one queue and rearrange all elements in one push()
O(n) push(),O(n)

*/

class MyStack {
    
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for (int i = 1; i < queue.size(); ++i) queue.offer(queue.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}


/*

Solution 2: use two queues, and reverse their elements each time pop() and top()
O(n) pop() and top(), O(n)

*/

class MyStack {
    
    private Queue<Integer> queue;
    private Queue<Integer> tmp;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
        this.tmp = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue.size() > 1) tmp.offer(queue.poll());
        int ans = queue.poll();
        queue = tmp;
        tmp = new LinkedList<>();
        return ans;
    }
    
    /** Get the top element. */
    public int top() {
        while (queue.size() > 1) tmp.offer(queue.poll());
        int ans = queue.peek();
        tmp.offer(queue.poll());
        queue = tmp;
        tmp = new LinkedList<>();
        return ans;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}




