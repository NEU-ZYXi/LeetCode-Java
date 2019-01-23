
/*

Given a binary tree, return the preorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,2,3]

*/

/*

Solution 1: recursively
O(n),O(n)

*/

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(ans, root);
    return ans;
}

private void dfs(List<Integer> ans, TreeNode root) {
    if (root == null) return;
    ans.add(root.val);
    dfs(ans, root.left);
    dfs(ans, root.right);
}


/*

Solution 2: iteratively
O(n),O(n)

*/

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerLast(root);
    while (!deque.isEmpty()) {
        TreeNode cur = deque.pollLast();
        ans.add(cur.val);
        if (cur.right != null) deque.offerLast(cur.right);
        if (cur.left != null) deque.offerLast(cur.left);
    }
    return ans;
}



