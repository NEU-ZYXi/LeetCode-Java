
/*

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

*/

/*

O(1),O(n)

*/

class MovingAverage {

    private Deque<Integer> deque;
    private int size;
    private int sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.deque = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        deque.offerLast(val);
        sum += val;
        if (deque.size() > size) sum -= deque.pollFirst();
        return sum * 1.0 / deque.size();
    }
}




