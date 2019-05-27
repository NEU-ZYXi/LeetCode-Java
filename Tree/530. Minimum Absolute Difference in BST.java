
/*

Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:
Input:
   1
    \
     3
    /
   2
Output:
1
Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).

*/

/*

O(n),O(n)

*/

public int getMinimumDifference(TreeNode root) {
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null, cur = root;
    Deque<TreeNode> deque = new ArrayDeque<>();
    while (cur != null || !deque.isEmpty()) {
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.left;
        }
        cur = deque.pollLast();
        if (prev != null) {
            ans = Math.min(ans, Math.abs(cur.val - prev.val));
        }
        prev = cur;
        cur = cur.right;
    }
    return ans;
}




