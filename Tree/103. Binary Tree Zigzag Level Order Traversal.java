
/*

Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

*/

/*

O(n),O(n)

*/

public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean flg = true;
    while (!queue.isEmpty()) {
        List<Integer> tmp = new ArrayList<>();
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            TreeNode cur = queue.poll();
            if (flg) tmp.add(cur.val);
            else tmp.add(0, cur.val);
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        ans.add(tmp);
        flg = !flg;
    }
    return ans;
}




