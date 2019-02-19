
/*

Given two 1d vectors, implement an iterator to return their elements alternately.

Example:
Input:
v1 = [1,2]
v2 = [3,4,5,6] 
Output: [1,3,2,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,3,2,4,5,6].

*/

/*

Solution 1: use built-in iterators and a queue to implement zigzag order
O(1),O(n)

*/

public class ZigzagIterator {
    
    private Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.queue = new LinkedList<>();
        if (v1.size() > 0) this.queue.offer(v1.iterator());
        if (v2.size() > 0) this.queue.offer(v2.iterator());
    }

    public int next() {
        Iterator it = queue.poll();
        int ans = (int)it.next();
        if (it.hasNext()) queue.offer(it);
        return ans;
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }
}


/*

Solution 2: use two indexes and a flag for zigzag order
O(1),O(n)

*/

public class ZigzagIterator {
    
    private List<Integer> v1, v2;
    private int i1, i2;
    private boolean zigzag;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.i1 = this.i2 = 0;
        this.zigzag = false;
    }

    public int next() {
        int ans = -1;
        if (i1 < v1.size() && !zigzag || v2.size() == i2) {
            ans = v1.get(i1);
            i1++;
        } else if (i2 < v2.size() && zigzag || v1.size() == i1) {
            ans = v2.get(i2);
            i2++;
        }
        zigzag = !zigzag;
        return ans;
    }

    public boolean hasNext() {
        return i1 < v1.size() || i2 < v2.size();
    }
}



