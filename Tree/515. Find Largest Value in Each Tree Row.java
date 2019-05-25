
/*

You need to find the largest value in each row of a binary tree.

Example:
Input: 
          1
         / \
        3   2
       / \   \  
      5   3   9 
Output: [1, 3, 9]

*/

/*

O(n),O(n)

*/

public List<Integer> largestValues(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int sz = queue.size(), max = Integer.MIN_VALUE;
        for (int i = 0; i < sz; ++i) {
            TreeNode cur = queue.poll();
            max = Math.max(max, cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        ans.add(max);
    }
    return ans;
}




