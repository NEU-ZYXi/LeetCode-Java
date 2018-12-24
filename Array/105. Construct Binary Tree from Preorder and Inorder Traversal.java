
/*

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
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

public TreeNode buildTree(int[] preorder, int[] inorder) {
    int n = preorder.length;
    if (n == 0) return null;
    return build(preorder, 0, n - 1, inorder, 0, n - 1);
}

private TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
    if (l1 > r1 || l2 > r2) return null;
    TreeNode root = new TreeNode(preorder[l1]);
    int idx = l2;
    while (idx <= r2) {
        if (inorder[idx] == root.val) break;
        idx++;
    }
    root.left = build(preorder, l1 + 1, l1 + idx - l2, inorder, l2, idx - 1);
    root.right = build(preorder, l1 + idx - l2 + 1, r1, inorder, idx + 1, r2);
    return root;
}



