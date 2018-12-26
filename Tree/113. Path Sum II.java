
/*

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:
[
   [5,4,11,2],
   [5,8,4,5]
]

*/

/*

O(n),O(logn)

*/

public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), root, sum);
    return ans;
}

private void dfs(List<List<Integer>> ans, List<Integer> tmp, TreeNode root, int sum) {
    if (root == null) return;
    tmp.add(root.val);
    if (root.left == null && root.right == null && root.val == sum) ans.add(new ArrayList<>(tmp));
    dfs(ans, tmp, root.left, sum - root.val);
    dfs(ans, tmp, root.right, sum - root.val);
    tmp.remove(tmp.size() - 1);
}



