
/*

Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:
Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:
Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

*/

/*

Solution 1.
O(nlogn)——O(n^2),O(logn)

*/

public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    int left = getDepth(root.left);
    int right = getDepth(root.right);
    return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
}

private int getDepth(TreeNode root) {
    if (root == null) return 0;
    int left = getDepth(root.left);
    int right = getDepth(root.right);
    return 1 + Math.max(left, right);
}


/*

Solution 2. -1 as the false flag
O(n),O(logn)

*/

public boolean isBalanced(TreeNode root) {
    return getDepth(root) != -1;
}

private int getDepth(TreeNode root) {
    if (root == null) return 0;
    int left = getDepth(root.left);
    if (left == -1) return -1;
    int right = getDepth(root.right);
    if (right == -1) return -1;
    if (Math.abs(left - right) > 1) return -1;
    return 1 + Math.max(left, right);
}




