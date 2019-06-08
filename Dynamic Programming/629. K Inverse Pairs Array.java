
/*

Given two integers n and k, find how many different arrays consist of numbers from 1 to n 
such that there are exactly k inverse pairs.
We define an inverse pair as following: For ith and jth element in the array, 
if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.
Since the answer may be very large, the answer should be modulo 109 + 7.

Example 1:
Input: n = 3, k = 0
Output: 1
Explanation: 
Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pair.

Example 2:
Input: n = 3, k = 1
Output: 2
Explanation: 
The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.

*/

/*

Solution: dp[i][j] means the number of k inverse pairs for [1...n]
          dp[i][j]=dp[i-1][j]+dp[i-1][j-1]+dp[i-1][j-2]+... which means insert nth number in each position
          1. dp[i][j]=dp[i-1][j]+dp[i-1][j-1]+dp[i-1][j-2]+...+dp[i-1][j-(n-2)]+dp[i-1][j-(n-1)]
          2. dp[i][j+1]=dp[i-1][j+1]+dp[i-1][j]+dp[i-1][j-1]+...+dp[i-1][j-(n-2)]
          then we have dp[i][j+1]-dp[i][j]=dp[i-1][j+1]-dp[i-1][j-(n-1)]
          dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-i]
O(nk),O(nk)          

*/

public int kInversePairs(int n, int k) {
    int MOD = 1000000007;
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 0; i <= n; ++i) {
        dp[i][0] = 1;
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= k; ++j) {
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            if (j >= i) {
                dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + MOD) % MOD;
            }
        }
    }
    return dp[n][k];
}




