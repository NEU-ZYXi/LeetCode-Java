
/*

Given a binary tree, we install cameras on the nodes of the tree. 
Each camera at a node can monitor its parent, itself, and its immediate children.
Calculate the minimum number of cameras needed to monitor all nodes of the tree.

Example 1:
Input: [0,0,null,0,0]
Output: 1

Example 2:
Input: [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. 

*/

/*

Solution: use 0,1,2 to represent monitoring status
          greedily mark node cam which means only when either its left or right child is not monitored, mark it cam
          DFS from the leaf nodes to accumulate the ans
O(n),O(logn)          

*/

private int NOT_MONITORED = 0;
private int MONITORED_NOCAM = 1;
private int MONITORED_WITHCAM = 2;
private int ans = 0;

public int minCameraCover(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int top = dfs(root);
    return ans + (top == NOT_MONITORED ? 1 : 0);
}

private int dfs(TreeNode root) {
    if (root == null) {
        return MONITORED_NOCAM;
    } 
    int left = dfs(root.left), right = dfs(root.right);
    if (left == MONITORED_NOCAM && right == MONITORED_NOCAM) {
        return NOT_MONITORED;
    } else if (left == NOT_MONITORED || right == NOT_MONITORED) {
        ans++;
        return MONITORED_WITHCAM;
    } else {
        return MONITORED_NOCAM;
    }
}



