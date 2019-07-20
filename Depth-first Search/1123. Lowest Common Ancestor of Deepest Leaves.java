
/*

Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.
Recall that:
The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.
 
Example 1:
Input: root = [1,2,3]
Output: [1,2,3]
Explanation: 
The deepest leaves are the nodes with values 2 and 3.
The lowest common ancestor of these leaves is the node with value 1.
The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".

Example 2:
Input: root = [1,2,3,4]
Output: [4]

Example 3:
Input: root = [1,2,3,4,5]
Output: [2,4,5]

*/

/*

Solution: keep track the max depth and current LCA
          DFS to get the current max depth of left and right subtree, if they equal to global max depth, update LCA node
O(n),O(logn)          

*/

private int maxDepth;
private TreeNode ans;

public TreeNode lcaDeepestLeaves(TreeNode root) {
    dfs(root, 0);
    return ans;
}

private int dfs(TreeNode root, int depth) {
    maxDepth = Math.max(maxDepth, depth);
    if (root == null) {
        return depth;
    }
    int l = dfs(root.left, depth + 1);
    int r = dfs(root.right, depth + 1);
    if (maxDepth == l && maxDepth == r) {
        ans = root;
    }
    return Math.max(l, r);
}



