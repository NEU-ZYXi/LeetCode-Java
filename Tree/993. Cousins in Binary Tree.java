
/*

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

*/

/*

Solution 1: BFS level order traversal
O(n),O(n)

*/

public boolean isCousins(TreeNode root, int x, int y) {
    if (root == null) {
        return false;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int size = queue.size();
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < size; ++i) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                if (cur.val == x) {
                    idx1 = i;
                } else if (cur.val == y) {
                    idx2 = i;
                }
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        if (idx1 != -1 && idx2 != -1) {
            if (idx1 / 2 != idx2 / 2) {
                return true;
            }
        }
        if (idx1 != -1 || idx2 != -1) {
            return false;
        }
    }
    return false;
}


/*

Solution 2: DFS level order traversal
O(n),O(logn)

*/

private int depthX = 0;
private int depthY = 0;
private TreeNode parentX = null;
private TreeNode parentY = null;

public boolean isCousins(TreeNode root, int x, int y) {
    dfs(root, x, y, 0, null);
    return depthX == depthY && parentX != parentY;
}

private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
    if (root == null) {
        return;
    }
    if (root.val == x) {
        depthX = depth;
        parentX = parent;
    } else if (root.val == y) {
        depthY = depth;
        parentY = parent;
    }
    dfs(root.left, x, y, depth + 1, root);
    dfs(root.right, x, y, depth + 1, root);
}




