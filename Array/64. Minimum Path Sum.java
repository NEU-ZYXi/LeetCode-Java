
/*

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/

/*

O(nm),O(nm)

*/

public int minPathSum(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int[][] dp = new int[n][m];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < n; ++i) dp[i][0] = dp[i - 1][0] + grid[i][0];
    for (int j = 1; j < m; ++j) dp[0][j] = dp[0][j - 1] + grid[0][j];
    for (int i = 1; i < n; ++i) {
        for (int j = 1; j < m; ++j)
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
    }
    return dp[n - 1][m - 1];
}



