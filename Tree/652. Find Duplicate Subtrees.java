
/*

Given a binary tree, return all duplicate subtrees.
For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with same node values.

Example 1:
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.

*/

/*

O(n^2),O(n)

*/

public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    dfs(ans, map, root);
    return ans;
}

private String dfs(List<TreeNode> ans, Map<String, Integer> map, TreeNode root) {
    if (root == null) {
        return "#";
    }
    String left = dfs(ans, map, root.left);
    String right = dfs(ans, map, root.right);
    String cur = root.val + left + right;
    map.put(cur, map.getOrDefault(cur, 0) + 1);
    if (map.get(cur) == 2) {
        ans.add(root);
    }
    return cur;
}




