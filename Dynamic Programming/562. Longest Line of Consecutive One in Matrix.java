
/*

Given a 01 matrix M, find the longest line of consecutive one in the matrix. 
The line could be horizontal, vertical, diagonal or anti-diagonal.

Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3

*/

/*

Solution: dp[i][j][k]=dp[i-1][j][k] up or dp[i][j-1][k] left or dp[i-1][j-1][k] topleft or dp[i-1][j+1][k] topright
O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {-1, 1}, {-1, -1}};
    
public int longestLine(int[][] M) {
    if (M.length == 0) {
        return 0;
    }
    int n = M.length, m = M[0].length, ans = 0;
    int[][][] dp = new int[n + 2][m + 2][4];
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (M[i - 1][j - 1] == 1) {
                for (int k = 0; k < 4; ++k) {
                    dp[i][j][k] = dp[i + dirs[k][0]][j + dirs[k][1]][k] + 1;
                    ans = Math.max(ans, dp[i][j][k]);
                }
            }
        }
    }
    return ans;
}




