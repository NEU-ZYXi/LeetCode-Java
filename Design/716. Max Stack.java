
/*

Design a max stack that supports push, pop, top, peekMax and popMax.
push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. 
If you find more than one maximum elements, only remove the top-most one.

Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5

*/

/*

Solution: use a deque to store all elements, a deque to store the current max element so far
          when popMax(), use a tmp deque to store all elements until we find the current max 
          then, push back the tmp deque into maxStack
O(n),O(n)          

*/

class MaxStack {
    private Deque<Integer> deque;
    private Deque<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        this.deque = new ArrayDeque<>();
        this.maxStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peekLast();
        maxStack.offerLast(max < x ? x : max);
        deque.offerLast(x);
    }
    
    public int pop() {
        maxStack.pollLast();
        return deque.pollLast();
    }
    
    public int top() {
        return deque.peekLast();
    }
    
    public int peekMax() {
        return maxStack.peekLast();
    }
    
    public int popMax() {
        int max = peekMax();
        Deque<Integer> tmp = new ArrayDeque<>();
        while (top() != max) {
            tmp.offerLast(pop());
        }
        pop();
        while (!tmp.isEmpty()) {
            push(tmp.pollLast());
        }
        return max;
    }
}




