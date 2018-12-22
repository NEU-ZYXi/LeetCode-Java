
/*

Given a binary tree, return the inorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,3,2]

*/

/*

O(n),O(n)

*/

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(ans, root);
    return ans;
}

private void dfs(List<Integer> ans, TreeNode root) {
    if (root == null) return;
    dfs(ans, root.left);
    ans.add(root.val);
    dfs(ans, root.right);
}


/*

O(n),O(n)

*/

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();
    TreeNode cur = root;
    while (!deque.isEmpty() || cur != null) {
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.left;
        }
        cur = deque.pollLast();
        ans.add(cur.val);
        cur = cur.right;
    }
    return ans;
}



