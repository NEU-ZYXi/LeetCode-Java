
/*

Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

*/

/*

O(n),O(logn)

*/

public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root.left == null && root.right == null) return root.val == sum;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}


/*

O(n),O(n)

*/

public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> sums = new LinkedList<>();
    queue.offer(root);
    sums.offer(sum);
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            TreeNode curNode = queue.poll();
            int curSum = sums.poll();
            if (curNode.left == null && curNode.right == null && curSum == curNode.val) return true;
            if (curNode.left != null) {
                queue.offer(curNode.left);
                sums.offer(curSum - curNode.val);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                sums.offer(curSum - curNode.val);
            }
        }
    }
    return false;
}




