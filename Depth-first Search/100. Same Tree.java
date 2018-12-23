
/*

Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]
Output: true

Example 2:
Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]
Output: false

Example 3:
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]
Output: false

*/

/*

O(n),O(logn)

*/

public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null || q == null) return p == q;
    if (p.val != q.val) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}


/*

O(n),O(n)

*/

public boolean isSameTree(TreeNode p, TreeNode q) {
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerLast(p);
    deque.offerLast(q);
    while (!deque.isEmpty()) {
        TreeNode curQ = deque.pollLast();
        TreeNode curP = deque.pollLast();
        if (curP == null && curQ == null) continue;
        if (curP == null || curQ == null || curP.val != curQ.val) return false;
        deque.offerLast(curP.left);
        deque.offerLast(curQ.left);
        deque.offerLast(curP.right);
        deque.offerLast(curQ.right);
    }
    return true;
}





