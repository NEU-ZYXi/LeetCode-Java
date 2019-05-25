
/*

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:
    2
   / \
  1   3
Output:
1

Example 2: 
Input:
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
Output:
7

*/

/*

Solution 1: level order BFS
O(n),O(n)

*/

public int findBottomLeftValue(TreeNode root) {
    if (root == null) {
        return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            TreeNode cur = queue.poll();
            if (i == 0) {
                ans = cur.val;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    return ans;
}


/*

Solution 2: any order traversal DFS
O(n),O(logn)

*/

private int ans = 0;
private int level = -1;

public int findBottomLeftValue(TreeNode root) {
    dfs(root, 0);
    return ans;
}

private void dfs(TreeNode root, int depth) {
    if (root == null) {
        return;
    }
    dfs(root.left, depth + 1);
    if (depth > level) {
        level = depth;
        ans = root.val;
    }
    dfs(root.right, depth + 1);
}





