
/*

Given a binary tree, count the number of uni-value subtrees.
A Uni-value subtree means all nodes of the subtree have the same value.

Example :
Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5
Output: 4

*/

/*

Solution: check each node from bottom, if left and right are univalue subtrees, then should be root.val=left.val=right.val
O(n),O(logn)

*/

public int countUnivalSubtrees(TreeNode root) {
    int[] ans = new int[1];
    dfs(ans, root);
    return ans[0];
}

private boolean dfs(int[] ans, TreeNode root) {
    if (root == null) return true;
    boolean left = dfs(ans, root.left), right = dfs(ans, root.right);
    if (left && right) {
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        ans[0]++;
        return true;
    }
    return false;
}




