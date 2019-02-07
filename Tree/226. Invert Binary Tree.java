
/*

Invert a binary tree.

Example:
Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:
     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/

/*

Solution 1: recursively invert left and right subtrees
O(n),O(logn)

*/

public TreeNode invertTree(TreeNode root) {
    if (root == null) return root;
    TreeNode tmp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(tmp);
    return root;
}


/*

Solution 2: invert each node on by one iteratively
O(n),O(n)

*/

public TreeNode invertTree(TreeNode root) {
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerLast(root);
    while (!deque.isEmpty()) {
        TreeNode cur = deque.pollLast();
        if (cur != null) {
            deque.offerLast(cur.left);
            deque.offerLast(cur.right);
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
        }
    }
    return root;
}




