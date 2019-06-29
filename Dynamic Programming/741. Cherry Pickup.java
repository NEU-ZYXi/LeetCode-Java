
/*

In a N x N grid representing a field of cherries, each cell is one of three possible integers.
0 means the cell is empty, so you can pass through;
1 means the cell contains a cherry, that you can pick up and pass through;
-1 means the cell contains a thorn that blocks your way.
Your task is to collect maximum number of cherries possible by following the rules below:
Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
 
Example 1:
Input: grid =
[[0, 1, -1],
 [1, 0, -1],
 [1, 1,  1]]
Output: 5
Explanation: 
The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up during this single trip, and the matrix becomes [[0,1,-1],[0,0,-1],[0,0,0]].
Then, the player went left, up, up, left to return home, picking up one more cherry.
The total number of cherries picked up is 5, and this is the maximum possible.

*/

/*

Solution: same as let two people go from (0,0) to (n-1,n-1) and find the max number of cherries they can pick up
          dp[i][j][p] means the max number we can get with one person on (i-1,j-1) and the other on (p-1,i+j-p)
          dp[i][j][p]=max(dp[i-1][j][p],dp[i-1][j][p-1],dp[i][j-1][p],dp[i][j-1][p-1]) which means four combination of movements
          notice that for same position, it can be only counted once
O(n^3),O(n^3)          

*/

public int cherryPickup(int[][] grid) {
    int n = grid.length;
    int[][][] dp = new int[n + 1][n + 1][n + 1];
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= n; ++j) {
            Arrays.fill(dp[i][j], Integer.MIN_VALUE);
        }
    }
    dp[1][1][1] = grid[0][0];
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            for (int p = 1; p <= n; ++p) {
                int q = i + j - p;
                if (q <= 0 || q > n || grid[i - 1][j - 1] == -1 || grid[p - 1][q - 1] == -1) {
                    continue;
                }
                int cur = Math.max(Math.max(Math.max(dp[i - 1][j][p], dp[i - 1][j][p - 1]), dp[i][j - 1][p]), dp[i][j - 1][p - 1]);
                if (cur != Integer.MIN_VALUE) {
                    dp[i][j][p] = cur + grid[i - 1][j - 1];
                    if (i != p || j != q) {
                        dp[i][j][p] += grid[p - 1][q - 1];
                    }
                }
            }
        }
    }
    return dp[n][n][n] == Integer.MIN_VALUE ? 0 : dp[n][n][n];
}




