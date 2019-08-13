
/*

Given a string, your task is to count how many palindromic substrings in this string.
The substrings with different start indexes or end indexes are counted as different substrings 
even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

*/

/*

O(n^2),O(n)

*/

public int countSubstrings(String s) {
    int n = s.length(), ans = 0;
    boolean[][] dp = new boolean[n][n];
    for (int j = 0; j < n; ++j) {
        for (int i = j; i >= 0; --i) {
            if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                dp[i][j] = true;
            }
            if (dp[i][j]) {
                ans++;
            }
        }
    }
    return ans;
}




