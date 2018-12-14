
/*

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:
s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 4:
Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

Example 5:
Input:
s = "acdcb"
p = "a*c?b"
Output: false

*/

/*

Solution 1.
dp[i][j] means whether s[0...i] and p[0...j] is match
dp[i][j]=dp[i-1][j-1], if s[i]=p[j] or p[j]='?'
otherwise, if p[j]='*'
dp[i][j]=dp[i][j-1], * means empty
        =dp[i-1][j-1], * means one character
        =dp[i-1][j], * means more characters which we could remove the character in s
O(nm),O(nm)        

*/

public boolean isMatch(String s, String p) {
    int n = s.length(), m = p.length();
    boolean[][] dp = new boolean[n + 1][m + 1];
    dp[0][0] = true;
    for (int j = 1; j <= m; ++j) {
        if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') 
                dp[i][j] = dp[i - 1][j - 1];
            else if (p.charAt(j - 1) == '*')
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i - 1][j - 1];
        }
    }
    return dp[n][m];
}


/*

Solution 2.
if s[i]==p[j] or p[j]=='?': i++,j++
if p[j]=='*': mark the current i and j, keep going through s[i...] and p[j+1...]
if s[i...] and p[j+1...] cannot match, go back to the last i and j
   do the same for s[i+1...] and p[j+1...] which is a backtracking way until we find how many characters the '*' should match
O(nm),O(1)

*/

public boolean isMatch(String s, String p) {
    int i = 0, j = 0, lastI = 0, lastJ = -1;
    while (i < s.length()) {
        if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
            i++;
            j++;
        } else if (j < p.length() && p.charAt(j) == '*') {
            lastI = i;
            lastJ = j;
            j++;
        } else if (lastJ != -1) {
            i = ++lastI;
            j = lastJ + 1;
        } else return false;
    }
    while (j < p.length() && p.charAt(j) == '*') j++;
    return j == p.length();
}




