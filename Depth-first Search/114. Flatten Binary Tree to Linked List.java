
/*

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

*/

/*

O(n),O(logn)

*/

public void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.left);
    flatten(root.right);
    TreeNode p = root.left;
    while (p != null && p.right != null) p = p.right;
    if (p != null) {
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}


public void flatten(TreeNode root) {
    while (root != null) {
        TreeNode p = root.left;
        if (p != null) {
            while (p.right != null) p = p.right;
            p.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        root = root.right;
    }
}


