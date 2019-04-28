
/*

Find the sum of all left leaves in a given binary tree.

Example:
    3
   / \
  9  20
    /  \
   15   7
There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

*/

/*

Solution 1: level order traversal
O(n),O(n)

*/

public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        if (cur.left != null && cur.left.left == null && cur.left.right == null) ans += cur.left.val;
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
    }
    return ans;
}


/*

Solution 2: recursively sum the left and right subtrees
O(n),O(logn)

*/

public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    int ans = 0;
    if (root.left != null) {
        if (root.left.left == null && root.left.right == null) ans += root.left.val;
        ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);
    return ans;
}



