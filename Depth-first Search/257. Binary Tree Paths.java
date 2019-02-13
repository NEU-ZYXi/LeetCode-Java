
/*

Given a binary tree, return all root-to-leaf paths.
Note: A leaf is a node with no children.

Example:
Input:
   1
 /   \
2     3
 \
  5
Output: ["1->2->5", "1->3"]
Explanation: All root-to-leaf paths are: 1->2->5, 1->3

*/

/*

O(nlogn),O(logn)

*/

public List<String> binaryTreePaths(TreeNode root) {
    List<String> ans = new ArrayList<>();
    dfs(ans, new StringBuilder(), root);
    return ans;
}

private void dfs(List<String> ans, StringBuilder tmp, TreeNode root) {
    if (root == null) return;
    tmp.append(tmp.length() == 0 ? "" : "->").append(root.val);
    if (root.left == null && root.right == null) {
        ans.add(tmp.toString());
        return;
    }
    int len = tmp.length();
    dfs(ans, tmp, root.left);
    tmp.setLength(len);
    dfs(ans, tmp, root.right);
    tmp.setLength(len);
}



