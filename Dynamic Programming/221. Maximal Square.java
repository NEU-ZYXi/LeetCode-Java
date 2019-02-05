
/*

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:
Input: 
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Output: 4

*/

/*

Solution: dp[i][j] means the side length of maximal square using matrix[i][j]
          matrix[i][j] can form a larger square only when matrix[i-1][j-1], matrix[i-1][j] and matrix[i][j-1] are '1'
          the same for the other three elements and so on
          dp[i][j]=min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1 to get the side length
          find the maximum side length on the way
O(nm),O(nm)          

*/

public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int n = matrix.length, m = matrix[0].length;
    int[][] dp = new int[n][m];
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        dp[i][0] = matrix[i][0] - '0';
        ans = Math.max(ans, dp[i][0]);
    }
    for (int j = 0; j < m; ++j) {
        dp[0][j] = matrix[0][j] - '0';
        ans = Math.max(ans, dp[0][j]);
    }
    for (int i = 1; i < n; ++i) {
        for (int j = 1; j < m; ++j) {
            if (matrix[i][j] == '1') {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                ans = Math.max(ans, dp[i][j] * dp[i][j]);
            }
        }
    }
    return ans;
}


public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int n = matrix.length, m = matrix[0].length;
    int[] dp = new int[m];
    int ans = 0, prev = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            int tmp = dp[j];
            if (i == 0 || j == 0 || matrix[i][j] == '0') dp[j] = matrix[i][j] - '0';
            else dp[j] = Math.min(prev, Math.min(dp[j], dp[j - 1])) + 1;
            ans = Math.max(ans, dp[j] * dp[j]);
            prev = tmp;
        }
    }
    return ans;
}
