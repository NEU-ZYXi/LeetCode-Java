
/*

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

*/

/*

Solution 1: find the first occurrence of p or q in the left and right subtree
            1. if left!=null and right!=null, which means p and q are in different subtrees, root is LCA
            2. if left=null, which means right is LCA
            3. if right=null, which means left is LCA
O(n),O(logn)            

*/

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) return root;
    if (left == null) return right;
    else return left;
}


/*

Solution 2: use map in level order traversal to track the path to p and q
            use set to get the path to p, and the intersection with path to q is the LCA
O(n),O(n)            

*/

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    Queue<TreeNode> queue = new LinkedList<>();
    map.put(root, null);
    queue.offer(root);
    while (!map.containsKey(p) || !map.containsKey(q)) {
        TreeNode cur = queue.poll();
        if (cur.left != null) {
            map.put(cur.left, cur);
            queue.offer(cur.left);
        }
        if (cur.right != null) {
            map.put(cur.right, cur);
            queue.offer(cur.right);
        }
    }
    Set<TreeNode> path = new HashSet<>();
    while (p != null) {
        path.add(p);
        p = map.get(p);
    }
    while (!path.contains(q)) q = map.get(q);
    return q;
}




