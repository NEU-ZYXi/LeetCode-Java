
/*

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

/*

Solution: dp[i] means the number of unique BST of length i
          choose each node j as the root node, and the left tree is built from dp[j-1], right tree is built from dp[i-j]
          for each 1<=j<=i, dp[i]+=dp[j-1]*dp[i-j]
O(n^2),O(n)

*/

public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;
    for (int i = 2; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) dp[i] += dp[j - 1] * dp[i - j];
    }
    return dp[n];
}


public int numTrees(int n) {
    int[] memo = new int[n + 1];
    memo[0] = memo[1] = 1;
    return solve(n, memo);
}

private int solve(int n, int[] memo) {
    if (memo[n] > 0) return memo[n];
    int sum = 0;
    for (int i = 1; i <= n; ++i) {
        sum += solve(i - 1, memo) * solve(n - i, memo);
    }
    memo[n] = sum;
    return sum;
}





