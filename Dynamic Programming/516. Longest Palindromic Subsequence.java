
/*

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:
"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:
"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

*/

/*

Solution: dp[i][j] means the longest palindrome subsequence for s[i...j]
          dp[i][j]=dp[i+1][j-1]+2 if s[i]=s[j] so we could expand the current subsequence
          otherwise, dp[i][j]=max(dp[i+1][j],dp[i][j-1])
O(n^2),O(n^2)          

*/

public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n + 1][n + 1];
    for (int i = 1; i <= n; ++i) {
        dp[i][i] = 1;
    }
    for (int j = 1; j <= n; ++j) {
        for (int i = j - 1; i >= 1; --i) {
            if (s.charAt(i - 1) == s.charAt(j - 1)) {
                dp[i][j] = dp[i + 1][j - 1] + 2;
            } else {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[1][n];
    
    // print the longest palindrome subsequence
    StringBuilder sb = new StringBuilder();
    int max = dp[0][ls];
    for (int i = ls - 1; i >= 0; i--) {
        if (dp[0][i] < max) {
            sb.append(s.charAt(i));
            max = dp[0][i];
        }
    }
    System.out.println(sb.reverse().toString());
}





