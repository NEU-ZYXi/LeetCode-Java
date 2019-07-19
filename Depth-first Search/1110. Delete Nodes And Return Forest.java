
/*

Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest.  You may return the result in any order.

Example 1:
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

*/

/*

Solution: recursively DFS to set left and right subtree of current root node
          if we should delete current root node, add left or right subtree if any of them is not null
O(n),O(logn)          

*/

public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    List<TreeNode> ans = new ArrayList<>();
    Set<Integer> delete = new HashSet<>();
    for (int val : to_delete) {
        delete.add(val);
    }
    if (!delete.contains(root.val)) {
        ans.add(root);
    }
    dfs(ans, root, delete);
    return ans;
}

private TreeNode dfs(List<TreeNode> ans, TreeNode root, Set<Integer> delete) {
    if (root == null) {
        return null;
    }
    root.left = dfs(ans, root.left, delete);
    root.right = dfs(ans, root.right, delete);
    if (delete.contains(root.val)) {
        if (root.left != null) {
            ans.add(root.left);
        }
        if (root.right != null) {
            ans.add(root.right);
        }
        return null;
    }
    return root;
}



