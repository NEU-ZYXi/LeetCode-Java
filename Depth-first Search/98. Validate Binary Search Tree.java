
/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input:
    2
   / \
  1   3
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.

*/

/*

O(n),O(n)

*/

public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    Deque<TreeNode> deque = new ArrayDeque<>();
    TreeNode cur = root, prev = null;
    while (!deque.isEmpty() || cur != null) {
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.left;
        }
        cur = deque.pollLast();
        if (prev != null && prev.val >= cur.val) return false;
        prev = cur;
        cur = cur.right;
    }
    return true;
}


/*

O(n),O(logn)

*/

public boolean isValidBST(TreeNode root) {
    return isValid(root, null, null);
}

private boolean isValid(TreeNode root, Integer min, Integer max) {
    if (root == null) return true;
    if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
}




