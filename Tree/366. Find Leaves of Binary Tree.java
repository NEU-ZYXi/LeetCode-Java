
/*

Given a binary tree, collect a tree's nodes as if you were doing this: 
Collect and remove all leaves, repeat until the tree is empty.

Example:
Input: [1,2,3,4,5]
          1
         / \
        2   3
       / \     
      4   5    
Output: [[4,5,3],[2],[1]]

*/

/*

O(n),O(logn)

*/

public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, root);
    return ans;
}

private int dfs(List<List<Integer>> ans, TreeNode root) {
    if (root == null) return -1;
    int level = 1 + Math.max(dfs(ans, root.left), dfs(ans, root.right));
    if (ans.size() == level) ans.add(new ArrayList<>());
    ans.get(level).add(root.val);
    return level;
}




