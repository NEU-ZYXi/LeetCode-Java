
/*

Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].

*/

/*

O(nm),O(nm)

*/

public int findLength(int[] A, int[] B) {
    int ans = 0, n = A.length, m = B.length;
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (A[i - 1] == B[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
            ans = Math.max(ans, dp[i][j]);
        }
    }
    return ans;
}


public int findLength(int[] A, int[] B) {
    int ans = 0, n = A.length, m = B.length;
    int[] dp = new int[m + 1];
    for (int i = 1; i <= n; ++i) {
        for (int j = m; j >= 1; --j) {
            if (A[i - 1] == B[j - 1]) {
                dp[j] = dp[j - 1] + 1;
            } else {
                dp[j] = 0;
            }
            ans = Math.max(ans, dp[j]);
        }
    }
    return ans;
}




