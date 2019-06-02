
/*

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, 
where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

*/

/*

Solution: dp[i][j] means the min distance of word1[0...i] and word2[0...j]
          dp[i][j]=dp[i-1][j-1] if word1[i]=word2[j]
          otherwise, dp[i][j]=min(dp[i-1][j],dp[i][j-1])+1 which means delete in word1 to get word1[0...i-1] or delete in word2
O(nm),O(nm)          

*/

public int minDistance(String word1, String word2) {
    int n = word1.length(), m = word2.length();
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; ++i) {
        dp[i][0] = i;
    }
    for (int j = 0; j <= m; ++j) {
        dp[0][j] = j;
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
    }
    return dp[n][m];
}




