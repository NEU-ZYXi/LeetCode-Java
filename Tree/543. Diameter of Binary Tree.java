
/*

Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

*/

/*

Solution 1: recursively get the depth of current node, diameter is max(left+right)
O(n),O(logn)

*/

private int ans = 0;
    
public int diameterOfBinaryTree(TreeNode root) {
    getDepth(root);
    return ans;
}

private int getDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int left = getDepth(root.left);
    int right = getDepth(root.right);
    ans = Math.max(ans, left + right);
    return Math.max(left, right) + 1;
}


/*

Solution 2: iterative solution, use a map to track the children nodes
O(n),O(n)

*/

public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int ans = 0;
    Deque<TreeNode> deque = new ArrayDeque<>();
    Map<TreeNode, Integer> map = new HashMap<>();
    map.put(null, 0);
    deque.offerLast(root);
    while (!deque.isEmpty()) {
        TreeNode cur = deque.peekLast();
        if (cur.left != null && !map.containsKey(cur.left)) {
            deque.offerLast(cur.left);
        } else if (cur.right != null && !map.containsKey(cur.right)) {
            deque.offerLast(cur.right);
        } else {
            cur = deque.pollLast();
            int left = map.get(cur.left);
            int right = map.get(cur.right);
            ans = Math.max(ans, left + right);
            map.put(cur, Math.max(left, right) + 1);
        }
    }
    return ans;
}



