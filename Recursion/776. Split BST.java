
/*

Given a Binary Search Tree (BST) with root node root, and a target value V, 
split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, 
while the other subtree has all nodes that are greater than the target value. 
It's not necessarily the case that the tree contains a node with value V.
Additionally, most of the structure of the original tree should remain. 
Formally, for any child C with parent P in the original tree, if they are both in the same subtree after the split, 
then node C should still have the parent P.
You should output the root TreeNode of both subtrees after splitting, in any order.

Example 1:
Input: root = [4,2,6,1,3,5,7], V = 2
Output: [[2,1],[4,3,6,null,null,5,7]]
Explanation:
Note that root, output[0], and output[1] are TreeNode objects, not arrays.
The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
          4
        /   \
      2      6
     / \    / \
    1   3  5   7
while the diagrams for the outputs are:
          4
        /   \
      3      6      and    2
            / \           /
           5   7         1

*/

/*

Solution: if root val is less than V, DFS for right subtree, then ans[0] is root, ans[1] is right[1] and change right node
          otherwise, DFS for left subtree
O(logn),O(logn)          

*/

public TreeNode[] splitBST(TreeNode root, int V) {
    TreeNode[] ans = new TreeNode[2];
    if (root == null) {
        return ans;
    }
    if (root.val <= V) {
        ans[0] = root;
        TreeNode[] right = splitBST(root.right, V);
        ans[1] = right[1];
        root.right = right[0];
    } else {
        ans[1] = root;
        TreeNode[] left = splitBST(root.left, V);
        ans[0] = left[0];
        root.left = left[1];
    }
    return ans;
}



