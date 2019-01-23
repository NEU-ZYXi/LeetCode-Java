
/*

Given a binary tree, return the postorder traversal of its nodes' values.

Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [3,2,1]

*/

/*

Solution 1: recursively
O(n),O(n)

*/

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(ans, root);
    return ans;
}

private void dfs(List<Integer> ans, TreeNode root) {
    if (root == null) return;
    dfs(ans, root.left);
    dfs(ans, root.right);
    ans.add(root.val);
}


/*

Solution 2: iteratively
O(n^2),O(n)

*/

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerLast(root);
    while (!deque.isEmpty()) {
        TreeNode cur = deque.pollLast();
        ans.add(0, cur.val);
        if (cur.left != null) deque.offerLast(cur.left);
        if (cur.right != null) deque.offerLast(cur.right);
    }
    return ans;
}


/*

Solution 3: iteratively with topologically postorder
O(n),O(n)

*/

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> deque = new LinkedList<>();
    TreeNode cur = root, prev = null;
    while (!deque.isEmpty() || cur != null) {
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.left;
        }
        cur = deque.pollLast();
        if (cur.right != null && prev != cur.right) {
            deque.offerLast(cur);
            cur = cur.right;
            continue;
        }
        ans.add(cur.val);
        prev = cur;
        cur = null;
    }
    return ans;
}



