
/*

Given a binary tree where every node has a unique value, and a target key k, 
find the value of the nearest leaf node to target k in the tree.
Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. 
Also, a node is called a leaf if it has no children.
In the following examples, the input tree is represented in flattened form row by row.
The actual root tree given will be a TreeNode object.

Example 1:
Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2
Output: 2 (or 3)
Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.

Example 2:
Input:
root = [1], k = 1
Output: 1
Explanation: The nearest leaf node is the root node itself.

Example 3:
Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6
Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.

*/

/*

Solution: DFS to build parent map for target node, BFS to find the shortest path to leaf node
O(n),O(n)

*/

public int findClosestLeaf(TreeNode root, int k) {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    TreeNode target = dfs(root, parent, k);
    Queue<TreeNode> queue = new LinkedList<>();
    Set<TreeNode> vis = new HashSet<>();
    queue.offer(target);
    vis.add(target);
    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        if (cur.left == null && cur.right == null) {
            return cur.val;
        }
        if (cur.left != null && vis.add(cur.left)) {
            queue.offer(cur.left);
        }
        if (cur.right != null && vis.add(cur.right)) {
            queue.offer(cur.right);
        }
        if (parent.containsKey(cur) && vis.add(parent.get(cur))) {
            queue.offer(parent.get(cur));
        }
    }
    return -1;
}

private TreeNode dfs(TreeNode root, Map<TreeNode, TreeNode> parent, int k) {
    if (root.val == k) {
        return root;
    }
    if (root.left != null) {
        parent.put(root.left, root);
        TreeNode left = dfs(root.left, parent, k);
        if (left != null) {
            return left;
        }
    }
    if (root.right != null) {
        parent.put(root.right, root);
        TreeNode right = dfs(root.right, parent, k);
        if (right != null) {
            return right;
        }
    }
    return null;
}




