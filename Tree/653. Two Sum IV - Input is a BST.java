
/*

Given a Binary Search Tree and a target number, 
return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7
Target = 9
Output: True
 
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7
Target = 28
Output: False

*/

/*

O(n),O(n)

*/

public boolean findTarget(TreeNode root, int k) {
    Set<Integer> set = new HashSet<>();
    return dfs(root, set, k);
}

private boolean dfs(TreeNode root, Set<Integer> set, int k) {
    if (root == null) {
        return false;
    }
    if (set.contains(k - root.val)) {
        return true;
    }
    set.add(root.val);
    return dfs(root.left, set, k) || dfs(root.right, set, k);
}




