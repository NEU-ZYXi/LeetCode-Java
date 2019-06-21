
/*

Given a binary tree, each node has value 0 or 1.  
Each root-to-leaf path represents a binary number starting with the most significant bit.  
For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
Return the sum of these numbers.

Example 1:
Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

*/

/*

O(n),O(logn)

*/

public int sumRootToLeaf(TreeNode root) {
    return dfs(root, 0);
}

private int dfs(TreeNode root, int cur) {
    if (root == null) {
        return 0;
    }
    cur = (cur << 1) + root.val;
    if (root.left == null && root.right == null) {
        return cur;
    } else {
        return dfs(root.left, cur) + dfs(root.right, cur);
    }
}



