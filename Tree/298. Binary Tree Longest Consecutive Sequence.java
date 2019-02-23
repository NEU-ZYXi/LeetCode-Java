
/*

Given a binary tree, find the length of the longest consecutive sequence path.
The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:
Input:
   1
    \
     3
    / \
   2   4
        \
         5
Output: 3
Explanation: Longest consecutive sequence path is 3-4-5, so return 3.

Example 2:
Input:
   2
    \
     3
    / 
   2    
  / 
 1
Output: 2 
Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.

*/

/*

O(n),O(logn)

*/

public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;
    return dfs(root, 0, root.val);
} 

private int dfs(TreeNode root, int ans, int target) {
    if (root == null) return ans;
    if (root.val == target) ans++;
    else ans = 1;
    int left = dfs(root.left, ans, root.val + 1);
    int right = dfs(root.right, ans, root.val + 1);
    return Math.max(ans, Math.max(left, right));
}




