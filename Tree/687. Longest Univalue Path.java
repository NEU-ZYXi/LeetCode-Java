
/*

Given a binary tree, find the length of the longest path where each node in the path has the same value. 
This path may or may not pass through the root.
The length of path between two nodes is represented by the number of edges between them.

Example 1:
Input:
      5
     / \
    4   5
   / \   \
  1   1   5
Output: 2

Example 2:
Input:
      1
     / \
    4   5
   / \   \
  4   4   5
Output: 2

*/

/*

O(n),O(logn)

*/

private int ans = 0;
    
public int longestUnivaluePath(TreeNode root) {
    univaluePath(root);
    return ans;
}

private int univaluePath(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int left = univaluePath(root.left);
    int right = univaluePath(root.right);
    int curLeft = 0, curRight = 0;
    if (root.left != null && root.val == root.left.val) {
        curLeft = left + 1;
    }
    if (root.right != null && root.val == root.right.val) {
        curRight = right + 1;
    }
    ans = Math.max(ans, curLeft + curRight);
    return Math.max(curLeft, curRight);
}





