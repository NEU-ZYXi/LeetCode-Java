
/*

Given a binary tree with n nodes, 
your task is to check if it's possible to partition the tree to two trees 
which have the equal sum of values after removing exactly one edge on the original tree.

Example 1:
Input:     
    5
   / \
  10 10
    /  \
   2   3
Output: True
Explanation: 
    5
   / 
  10
Sum: 15
   10
  /  \
 2    3
Sum: 15

Example 2:
Input:     
    1
   / \
  2  10
    /  \
   2   20
Output: False
Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.

*/

/*

O(n),O(n)

*/

public boolean checkEqualTree(TreeNode root) {
    if (root == null) {
        return false;
    }
    List<Integer> sums = new ArrayList<>();
    int sum = dfs(root, sums);
    if (sum % 2 != 0) {
        return false;
    }
    for (int i = 0; i < sums.size() - 1; ++i) {
        if (sums.get(i) * 2 == sum) {
            return true;
        }
    }
    return false;
}

private int dfs(TreeNode root, List<Integer> sums) {
    if (root == null) {
        return 0;
    }
    int sum = root.val + dfs(root.left, sums) + dfs(root.right, sums);
    sums.add(sum);
    return sum;
}




