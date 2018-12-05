
/*

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"

*/

/*

Solution: dp[i][j]=true, if s[i]=s[j] and dp[i+1][j-1]=true which means s[i+1...j-1] is palindromic
O(n^2),O(n^2)

*/

public String longestPalindrome(String s) {
    int n = s.length();
    String ans = "";
    boolean[][] dp = new boolean[n][n];
    for (int j = 0; j < n; ++j) {
        for (int i = j; i >= 0; --i) {
            if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]))
                dp[i][j] = true;
            if (dp[i][j] && ans.length() < j - i + 1) 
                ans = s.substring(i, j + 1);
        }
    }
    return ans;
}




