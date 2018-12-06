
/*

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:
s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

*/

/*

Solution: dp[i][j] means whether s[0...i] and p[0...j] is match
          dp[i][j]=dp[i-1][j-1], if s[i]=p[j] or p[j]='.'
          
          otherwise, if p[j]='*', compare s[i] and p[j-1]
          dp[i][j]=dp[i][j-2], * means empty
                  =dp[i][j-1], * means one character which is the previous one
                  =dp[i-1][j], * means more characters which we could remove the character in s
          dp[i][j]=dp[i][j-2], if s[i]!=p[j-1]
          
O(n^2),O(n^2)          

*/

public boolean isMatch(String s, String p) {
    int n = s.length(), m = p.length();
    boolean[][] dp = new boolean[n + 1][m + 1];
    dp[0][0] = true;
    for (int j = 1; j <= m; ++j) {
        if (p.charAt(j - 1) == '*')
            dp[0][j] = dp[0][j - 2];
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') 
                dp[i][j] = dp[i - 1][j - 1];
            else if (p.charAt(j - 1) == '*') {
                if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
                else 
                    dp[i][j] = dp[i][j - 2];
            }
        }
    }
    return dp[n][m];
}




