
/*

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

Example:
Input: root = [4,2,5,1,3], target = 3.714286
    4
   / \
  2   5
 / \
1   3
Output: 4

*/

/*

Solution 1: find the closest value from left or right subtree
O(logn),O(1)

*/

public int closestValue(TreeNode root, double target) {
    int ans = root.val;
    while (root != null) {
        if (Math.abs(root.val - target) < Math.abs(ans - target)) ans = root.val;
        root = root.val > target ? root.left : root.right;
    }
    return ans;
}


/*

Solution 2: recursively find in the left and right subtree
O(logn),O(logn)

*/

public int closestValue(TreeNode root, double target) {
    int ans1 = root.val;
    TreeNode nxt = root.val > target ? root.left : root.right;
    if (nxt == null) return ans1;
    int ans2 = closestValue(nxt, target);
    return Math.abs(ans1 - target) > Math.abs(ans2 - target) ? ans2 : ans1;
}




