
/*

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by 
deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:
Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)
rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^

Example 2:
Input: S = "babgbag", T = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)
babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

*/

/*

Solution: dp[i][j] means the number of distinct subsequences for s[0...i] and t[0...j], final state is dp[n][m]
          base case is that for each i in s[0...i], only one way to form t as "", which is dp[i][0]=1
          if s[i]=t[j] which means we could use s[i] to let s[0...i] forms t[0...j], that is dp[i-1][j-1]
                       also we could choose not to use s[i], that is dp[i-1][j]
                       so, dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
          otherwise, dp[i][j]=dp[i-1][j], which means s[i] is useless
O(nm),O(nm)

*/

public int numDistinct(String s, String t) {
    int n = s.length(), m = t.length();
    int[][] dp = new int[n + 1][m + 1];
    dp[0][0] = 1;
    for (int i = 1; i <= n; ++i) dp[i][0] = 1;
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            else dp[i][j] = dp[i - 1][j];
        }
    }
    return dp[n][m];
}


public int numDistinct(String s, String t) {
    int n = s.length(), m = t.length();
    int[] dp = new int[m + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; ++i) {
        int prev = 1;
        for (int j = 1; j <= m; ++j) {
            int tmp = dp[j];
            if (s.charAt(i - 1) == t.charAt(j - 1)) dp[j] += prev;
            prev = tmp;
        }
    }
    return dp[m];
}




