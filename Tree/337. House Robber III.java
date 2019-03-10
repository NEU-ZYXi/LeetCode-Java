
/*

The thief has found himself a new place for his thievery again. 
There is only one entrance to this area, called the "root." 
Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
Input: [3,2,3,null,3,null,1]
     3
    / \
   2   3
    \   \ 
     3   1
Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
Input: [3,4,5,1,3,null,1]
     3
    / \
   4   5
  / \   \ 
 1   3   1
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

*/

/*

Solution 1: DFS with memoization, compare root+left.left+left.right+right.left+right.right with left+right to find max
O(n),O(n)

*/

public int rob(TreeNode root) {
    Map<TreeNode, Integer> memo = new HashMap<>();
    return dfs(root, memo);
}

private int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
    if (root == null) return 0;
    if (memo.containsKey(root)) return memo.get(root);
    int ans = 0;
    if (root.left != null) ans += dfs(root.left.left, memo) + dfs(root.left.right, memo);
    if (root.right != null) ans += dfs(root.right.left, memo) + dfs(root.right.right, memo);
    ans = Math.max(ans + root.val, dfs(root.left, memo) + dfs(root.right, memo));
    memo.put(root, ans);
    return ans;
}


/*

Solution 2: ans[0] means the maximum value without root, ans[1] means the maximum value with root
            ans[0]=max(left)+max(right) which means we could either use left and right nodes or not
            ans[1]=root+left[0]+right[0] which means we could not use left and right nodes
O(n),O(n)

*/

public int rob(TreeNode root) {
    int[] ans = dfs(root);
    return Math.max(ans[0], ans[1]);
}

private int[] dfs(TreeNode root) {
    int[] ans = new int[2];
    if (root == null) return ans;
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);
    ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    ans[1] = root.val + left[0] + right[0];
    return ans;
}




