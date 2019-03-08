
/*

Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
where largest means subtree with largest number of nodes in it.
Note:
A subtree must include all of its descendants.

Example:
Input: [10,5,15,1,8,null,7]
   10 
   / \ 
  5  15 
 / \   \ 
1   8   7
Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one.
             The return value is the subtree's size, which is 3.

*/

/*

Solution 1: check if it's a valid BST and count number of nodes, recursively do it for left and right subtree to find largest
O(n^2),O(logn)

*/

public int largestBSTSubtree(TreeNode root) {
    if (root == null) return 0;
    if (isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) return count(root);
    return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
}

private boolean isValid(TreeNode root, Integer min, Integer max) {
    if (root == null) return true;
    if (min < root.val && root.val < max) return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    return false;
}

private int count(TreeNode root) {
    if (root == null) return 0;
    return 1 + count(root.left) + count(root.right);
}


/*

Solution 2: use a 3 elements array to store each recursive step
          ans[0] is the size, ans[1] is the min node in subtrees, ans[2] is the max node in subtrees
          if current root is a valid BST node, update min and max nodes, increase size by 1
          otherwise, set min and max as a boundary value which means all its parent nodes are not valid
O(n),O(logn)          

*/

public int largestBSTSubtree(TreeNode root) {
    if (root == null) return 0;
    int[] ans = dfs(root);
    return ans[0];
}

private int[] dfs(TreeNode root) {
    if (root == null) return new int[] {0, Integer.MAX_VALUE, Integer.MIN_VALUE};
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);
    if (left[2] < root.val && root.val < right[1]) {
        return new int[] {left[0] + right[0] + 1, Math.min(root.val, left[1]), Math.max(root.val, right[2])};
    } else {
        return new int[] {Math.max(left[0], right[0]), Integer.MIN_VALUE, Integer.MAX_VALUE};
    }
}



