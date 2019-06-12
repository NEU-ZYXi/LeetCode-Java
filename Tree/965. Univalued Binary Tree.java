
/*

A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.

Example 1:
Input: [1,1,1,1,1,null,1]
Output: true

Example 2:
Input: [2,2,2,5,2]
Output: false

*/

/*

O(n),O(logn)

*/

public boolean isUnivalTree(TreeNode root) {
    if (root == null) {
        return true;
    }
    if (root.left != null && root.val != root.left.val) {
        return false;
    }
    if (root.right != null && root.val != root.right.val) {
        return false;
    }
    return isUnivalTree(root.left) && isUnivalTree(root.right);
}



