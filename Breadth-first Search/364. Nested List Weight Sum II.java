
/*

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.
Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. 
i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Input: [[1,1],2,[1,1]]
Output: 8 
Explanation: Four 1's at depth 1, one 2 at depth 2.

Example 2:
Input: [1,[4,[6]]]
Output: 17 
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.

*/

/*

O(n),O(n)

*/

public int depthSumInverse(List<NestedInteger> nestedList) {
    Queue<NestedInteger> queue = new LinkedList<>();
    for (NestedInteger ni : nestedList) queue.offer(ni);
    int ans = 0, tmp = 0;
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            NestedInteger cur = queue.poll();
            if (cur.isInteger()) tmp += cur.getInteger();
            else queue.addAll(cur.getList());
        }
        ans += tmp;
    }
    return ans;
}




