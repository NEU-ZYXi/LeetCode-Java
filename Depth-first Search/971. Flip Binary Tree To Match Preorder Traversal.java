
/*

Given a binary tree with N nodes, each node has a different value from {1, ..., N}.
A node in this binary tree can be flipped by swapping the left child and the right child of that node.
Consider the sequence of N values reported by a preorder traversal starting from the root. 
Call such a sequence of N values the voyage of the tree.
(Recall that a preorder traversal of a node means we report the current node's value, 
then preorder-traverse the left child, then preorder-traverse the right child.)
Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.
If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.
If we cannot do so, then return the list [-1].

Example 1:
Input: root = [1,2], voyage = [2,1]
Output: [-1]

Example 2:
Input: root = [1,2,3], voyage = [1,3,2]
Output: [1]

Example 3:
Input: root = [1,2,3], voyage = [1,2,3]
Output: []

*/

/*

Solution: only when left is not voyage[i] and right is voyage[i], we need to flip the parent node
          then DFS the right subtree to find the next start index for left subtree
O(n),O(n)          

*/

public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
    List<Integer> ans = new ArrayList<>();
    return dfs(ans, root, voyage, 0) == -1 ? Arrays.asList(-1) : ans;
}

private int dfs(List<Integer> ans, TreeNode root, int[] voyage, int idx) {
    if (idx == -1) {
        return -1;
    }
    if (root == null) {
        return idx;
    }
    if (voyage[idx] != root.val) {
        return -1;
    }
    idx++;
    if (root.left != null && root.left.val != voyage[idx] && root.right != null && root.right.val == voyage[idx]) {
        ans.add(root.val);
        int next = dfs(ans, root.right, voyage, idx);
        return dfs(ans, root.left, voyage, next);
    }
    int next = dfs(ans, root.left, voyage, idx);
    return dfs(ans, root.right, voyage, next);
}




