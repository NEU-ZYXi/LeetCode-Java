
/*

Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

*/

/*

O(n^2),O(n), where ans.add(0,tmp) takes O(n) in worst case

*/

public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int sz = queue.size();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < sz; ++i) {
            TreeNode cur = queue.poll();
            tmp.add(cur.val);
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        ans.add(0, tmp);
    }
    return ans;
}



