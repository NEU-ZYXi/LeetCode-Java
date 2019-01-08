
/*

Given a non-empty binary tree, find the maximum path sum.

A path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

*/

/*

Solution: recursively get the left path sum and right path sum, drop the negative cases since it decreases the total path sum
          update the maximum ans during the process of traversing each node
          return the larger one of two subtrees
O(n),O(logn)

*/

private int ans = Integer.MIN_VALUE;
    
public int maxPathSum(TreeNode root) {
    pathSum(root);
    return ans;
}

private int pathSum(TreeNode root) {
    if (root == null) return 0;
    int left = Math.max(pathSum(root.left), 0);
    int right = Math.max(pathSum(root.right), 0);
    this.ans = Math.max(this.ans, root.val + left + right);
    return root.val + Math.max(left, right);
}



