
/*

Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

*/

/*

Solution 1: BFS levelorder traversal for each level to get the most rightside node
O(n),O(n)

*/

public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            TreeNode cur = queue.poll();
            if (i == sz - 1) ans.add(cur.val);
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
    }
    return ans;
}


/*

Solution 2: DFS levelorder traversal for each level to get the most rightside node
O(n),O(n)

*/

public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    dfs(ans, root, 0);
    return ans;
}

private void dfs(List<Integer> ans, TreeNode root, int depth) {
    if (root == null) return;
    if (ans.size() == depth) ans.add(root.val);
    dfs(ans, root.right, depth + 1);
    dfs(ans, root.left, depth + 1);
}



