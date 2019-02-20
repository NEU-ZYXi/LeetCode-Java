
/*

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
The successor of a node p is the node with the smallest key greater than p.val.

Example 1:
Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.

Example 2:
Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.

*/

/*

Solution 1: iterative binary search method
O(logn),O(1)

*/

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode ans = null;
    while (root != null) {
        if (root.val > p.val) {
            ans = root;
            root = root.left;
        } else root = root.right;
    }
    return ans;
}


/*

Solution 2: recursive way
O(logn),O(logn)

*/

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) return null;
    if (root.val > p.val) {
        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    } else return inorderSuccessor(root.right, p);
}



