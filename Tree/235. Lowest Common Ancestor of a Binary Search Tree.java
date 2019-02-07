
/*

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

*/

/*

Solution 1: recursively find the LCA in the left or right subtree
O(logn),O(logn)

*/

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
    else if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
    return root;
}


/*

Solution 2: iterative way
O(logn),O(1)

*/

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode cur = root;
    while (true) {
        if (cur.val > p.val && cur.val > q.val) cur = cur.left;
        else if (cur.val < p.val && cur.val < q.val) cur = cur.right;
        else return cur;
    }
}



