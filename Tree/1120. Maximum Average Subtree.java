
/*

Given the root of a binary tree, find the maximum average value of any subtree of that tree.
(A subtree of a tree is any node of that tree plus all its descendants. 
The average value of a tree is the sum of its values, divided by the number of nodes.)

Example 1:
Input: [5,6,1]
Output: 6.00000
Explanation: 
For the node with value = 5 we have and average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have and average of 6 / 1 = 6.
For the node with value = 1 we have and average of 1 / 1 = 1.
So the answer is 6 which is the maximum.

*/

/*

Solution: double[] for (sum, cnt, avg), DFS to get the left and right subtree
          compare sum/cnt and max(left avg, right avg) to find the larger one, then pass it to parent node
O(n),O(logn)

*/

public double maximumAverageSubtree(TreeNode root) {
    return dfs(root)[2];
}

private double[] dfs(TreeNode root) {
    if (root == null) {
        return new double[] {0, 0, 0};
    }
    double[] l = dfs(root.left);
    double[] r = dfs(root.right);
    double sum = root.val + l[0] + r[0], cnt = 1 + l[1] + r[1];
    double max = Math.max(sum / cnt, Math.max(l[2], r[2]));
    return new double[] {sum, cnt, max};
}



