
/*

Given a nested list of integers, implement an iterator to flatten it.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].
             
Example 2:
Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].

*/

/*

O(n) construct and hasNext, O(1) next, O(n)

*/

public class NestedIterator implements Iterator<Integer> {
    
    private Deque<NestedInteger> deque;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.deque = new LinkedList<>();
        for (int i = nestedList.size() - 1; i >= 0; --i) this.deque.offerLast(nestedList.get(i));
    }

    @Override
    public Integer next() {
        if (hasNext()) return deque.pollLast().getInteger();
        else return null;
    }

    @Override
    public boolean hasNext() {
        while (!deque.isEmpty()) {
            NestedInteger cur = deque.peekLast();
            if (cur.isInteger()) return true;
            else {
                deque.pollLast();
                for (int i = cur.getList().size() - 1; i >= 0; --i) deque.offerLast(cur.getList().get(i));
            }
        }
        return false;
    }
}




