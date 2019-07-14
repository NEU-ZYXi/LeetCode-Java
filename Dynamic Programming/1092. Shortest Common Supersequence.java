
/*

Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. 
If multiple answers exist, you may return any of them.
(A string S is a subsequence of string T if deleting some number of characters from T 
(possibly 0, and the characters are chosen anywhere from T) results in the string S.)

Example 1:
Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation: 
str1 = "abac" is a substring of "cabac" because we can delete the first "c".
str2 = "cab" is a substring of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.

*/

/*

Solution: find the length of Shortest Common Subsequence similar to LCS, dp[i][j] means the SCS for s1[0...i] and s2[0...j]
          dp[i][j]=dp[i-1][j-1]+1 if s1[i]=s2[j] which means append the s1[i]/s2[j] to SCS
          dp[i][j]=min(dp[i-1][j],dp[i][j-1])+1 otherwise which means use min of s1[0...i-1] or s2[0...j-1]
          reconstruct the SCS using dp array
O(nm),O(nm)          

*/

public String shortestCommonSupersequence(String str1, String str2) {
    int n = str1.length(), m = str2.length();
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; ++i) {
        dp[i][0] = i;
    }
    for (int j = 0; j <= m; ++j) {
        dp[0][j] = j;
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
    }
    int l = dp[n][m], i = n, j = m;
    char[] ans = new char[l];
    while (i > 0 && j > 0) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            ans[--l] = str1.charAt(i - 1);
            i--;
            j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            ans[--l] = str2.charAt(j - 1);
            j--;
        } else {
            ans[--l] = str1.charAt(i - 1);
            i--;
        }
    }
    while (i > 0) {
        ans[--l] = str1.charAt(i - 1);
        i--;
    }
    while (j > 0) {
        ans[--l] = str2.charAt(j - 1);
        j--;
    }
    return new String(ans);
}




