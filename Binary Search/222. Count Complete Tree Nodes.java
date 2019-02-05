
/*

Given a complete binary tree, count the number of nodes.

Note:
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:
Input: 
    1
   / \
  2   3
 / \  /
4  5 6
Output: 6

*/

/*

Solution 1: just count
O(n),O(logn)

*/

public int countNodes(TreeNode root) {
    if (root == null) return 0;
    return countNodes(root.left) + countNodes(root.right) + 1;
}


/*

Solution 2: get the height of the root, since it's complete tree, just get the number of leftmost nodes
            if the height(root)=height(root.right)+1, which means left subtree is full, it's 1<<(height-1)
            otherwise, which means right subtree is full without the last level, it's 1<<(height-2)
            recursively count the right or left subtree based on above conditions
O((logn)^2),O(logn)            

*/

public int countNodes(TreeNode root) {
    int height = getHeight(root);
    if (height == 0) return 0;
    else if (height == getHeight(root.right) + 1) return (1 << (height - 1)) + countNodes(root.right);
    else return (1 << (height - 2)) + countNodes(root.left);
}

private int getHeight(TreeNode root) {
    return root == null ? 0 : 1 + getHeight(root.left);
}




