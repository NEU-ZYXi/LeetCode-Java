
/*

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

*/

/*

Solution: dp[i][j] means whether s1[0...i] and s2[0...j] can interleave s3[0...i+j+1]
          base cases are s1[0...i] and s2 as "" to interleave s3, which means if s1[i]==s3[i], dp[i][0]=dp[i-1][0]
                         s1 as "" and s2[0...j] to interleave s3, which means if s2[j]==s3[j], dp[0][j]=dp[0][j-1]
          1. if s1[i]=s3[i+j+1] and dp[i-1][j] which means s1[0...i-1] and s2[0...j] can interleave s3[i+j], so dp[i][j]=true
          2. if s2[j]=s3[i+j+1] and dp[i][j-1] which means s1[0...i] and s2[0...j-1] can interleave s3[i+j], so dp[i][j]=true
O(nm),O(nm)

*/

public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) return false;
    int n = s1.length(), m = s2.length();
    boolean[][] dp = new boolean[n + 1][m + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; ++i) {
        if (s1.charAt(i - 1) == s3.charAt(i - 1)) dp[i][0] = dp[i - 1][0];
    }
    for (int j = 1; j <= m; ++j) {
        if (s2.charAt(j - 1) == s3.charAt(j - 1)) dp[0][j] = dp[0][j - 1];
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) || 
                (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1])) 
                dp[i][j] = true;
        }
    }
    return dp[n][m];
}




