
/*

Implement the following operations of a queue using stacks.
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

Example:
MyQueue queue = new MyQueue();
queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false

*/

/*

O(n) push(),O(n)

*/

class MyQueue {
    
    Stack<Integer> stack;
    Stack<Integer> tmp;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<>();
        this.tmp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.isEmpty()) tmp.push(stack.pop());
        stack.push(x);
        while (!tmp.isEmpty()) stack.push(tmp.pop());
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}


/*

O(n) pop() and peek(),O(n)

*/

class MyQueue {
    
    Stack<Integer> stack;
    Stack<Integer> tmp;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack<>();
        this.tmp = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (stack.size() > 1) tmp.push(stack.pop());
        int ans = stack.pop();
        while (!tmp.isEmpty()) stack.push(tmp.pop());
        return ans;
    }
    
    /** Get the front element. */
    public int peek() {
        while (stack.size() > 1) tmp.push(stack.pop());
        int ans = stack.peek();
        while (!tmp.isEmpty()) stack.push(tmp.pop());
        return ans;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}




