
/*

You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, 
but it must go downwards (traveling only from parent nodes to child nodes).
The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1
Return 3. The paths that sum to 8 are:
1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

*/

/*

Solution 1: O(nlogn),O(logn)

*/

public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;
    return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
}

private int dfs(TreeNode root, int sum) {
    if (root == null) return 0;
    sum -= root.val;
    int cnt = sum == 0 ? 1 : 0;
    return cnt + dfs(root.left, sum) + dfs(root.right, sum);
}


/*

Solution 2: keep adding to prefix sum of each path and use a hashmap to track, check the number of sub-path with target=cur-sum
O(n),O(n)

*/

public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;
    Map<Integer, Integer> memo = new HashMap<>();
    memo.put(0, 1);    
    return dfs(root, memo, sum, 0);
}

private int dfs(TreeNode root, Map<Integer, Integer> memo, int sum, int cur) {
    if (root == null) return 0;
    cur += root.val;
    int ans = memo.getOrDefault(cur - sum, 0);
    memo.put(cur, memo.getOrDefault(cur, 0) + 1);
    ans += dfs(root.left, memo, sum, cur) + dfs(root.right, memo, sum, cur);
    memo.put(cur, memo.get(cur) - 1);
    return ans;
}





