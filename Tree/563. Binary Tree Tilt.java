
/*

Given a binary tree, return the tilt of the whole tree.
The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values 
and the sum of all right subtree node values. Null node has tilt 0.
The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1

*/

/*

Solution 1: recursively sum each node's left and right subtree
O(n^2),O(logn)

*/

public int findTilt(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int ans = Math.abs(sum(root.left) - sum(root.right));
    return ans + findTilt(root.left) + findTilt(root.right);
}

private int sum(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return root.val + sum(root.left) + sum(root.right);
}


/*

Solution 2: sum up during the recursive process
O(n),O(logn)

*/

private int ans = 0;
    
public int findTilt(TreeNode root) {
    if (root == null) {
        return 0;
    }
    sum(root);
    return ans;
}

private int sum(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int left = sum(root.left);
    int right = sum(root.right);
    ans += Math.abs(left - right);
    return left + right + root.val;
}




