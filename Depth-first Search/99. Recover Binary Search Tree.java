
/*

Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.

Example 1:
Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
   
Example 2:
Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3

*/

/*

Solution 1. inorder traverse, and if we find prev.val>=cur.val which means prev node is the one not in order
            keep track of prev node, and when we find the last prev node where prev.val>=cur.val, it's the second one
O(n),O(n)            

*/

public void recoverTree(TreeNode root) {
    TreeNode cur = root, first = null, second = null, prev = null;
    Deque<TreeNode> deque = new LinkedList<>();
    while (!deque.isEmpty() || cur != null) {
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.left;
        }
        cur = deque.pollLast();
        if (first == null && prev != null && prev.val >= cur.val) first = prev;
        if (first != null && prev.val >= cur.val) second = cur;
        prev = cur;
        cur = cur.right;
    }
    int tmp = first.val;
    first.val = second.val;
    second.val = tmp;
}


/*

Solution 2. recursive method
O(n),O(logn)

*/

public void recoverTree(TreeNode root) {
    TreeNode[] ans = new TreeNode[3];
    Arrays.fill(ans, null);
    dfs(root, ans);
    int tmp = ans[1].val;
    ans[1].val = ans[2].val;
    ans[2].val = tmp;
}

private void dfs(TreeNode root, TreeNode[] ans) {
    if (root == null) return;
    dfs(root.left, ans);
    if (ans[1] == null && ans[0] != null && ans[0].val >= root.val) ans[1] = ans[0];
    if (ans[1] != null && ans[0].val >= root.val) ans[2] = root;
    ans[0] = root;
    dfs(root.right, ans);
}




