
/*

Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.

For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

*/

/*

O(n),O(logn)

*/

public TreeNode buildTree(int[] inorder, int[] postorder) {
    int n = inorder.length;
    if (n == 0) return null;
    return build(inorder, 0, n - 1, postorder, 0, n - 1);
}

private TreeNode build(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
    if (l1 > r1 || l2 > r2) return null;
    TreeNode root = new TreeNode(postorder[r2]);
    int idx = l1;
    while (idx <= r1) {
        if (inorder[idx] == root.val) break;
        idx++;
    }
    root.left = build(inorder, l1, idx - 1, postorder, l2, l2 + idx - l1 - 1);
    root.right = build(inorder, idx + 1, r1, postorder, l2 + idx - l1, r2 - 1);
    return root;
}




