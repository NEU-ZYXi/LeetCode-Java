
/*

Given a non-empty string, encode the string such that its encoded length is the shortest.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note:
k will be a positive integer and encoded string will not be empty or have extra space.
You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
If an encoding process does not make the string shorter, then do not encode it. 
If there are several solutions, return any of them is fine.
 
Example 1:
Input: "aaa"
Output: "aaa"
Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.
 
Example 2:
Input: "aaaaa"
Output: "5[a]"
Explanation: "5[a]" is shorter than "aaaaa" by 1 character.

Example 3:
Input: "aaaaaaaaaa"
Output: "10[a]"
Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".
 
Example 4:
Input: "aabcaabcd"
Output: "2[aabc]d"
Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".
 
Example 5:
Input: "abbbabbbcabbbabbbc"
Output: "2[2[abbb]c]"
Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".

*/

/*

Solution 1: dp[i][j] means the encoded string for s[i...j]
            for each length, for each i and j+len, dp[i][j] is s[i...j] if s[i...j] is shorter than 5
            otherwise, try to encode s[i...j] and find the shortest encoded one which is the longest substring as dp[i][j]
            then, for each i<=k<j, dp[i][j]=min(dp[i][k]+dp[k+1][j]) which means we could combine two parts to a shorter string
O(n^4),O(n^2)          

*/

public String encode(String s) {
    int n = s.length();
    String[][] dp = new String[n][n];
    for (int l = 0; l < n; ++l) {
        for (int i = 0; i < n - l; ++i) {
            int j = i + l;
            String cur = s.substring(i, j + 1);
            if (cur.length() < 5) {
                dp[i][j] = cur;
            } else {
                dp[i][j] = cur;
                for (int k = 0; k < cur.length(); ++k) {
                    String tmp = cur.substring(0, k + 1);
                    if (cur.length() % tmp.length() == 0 && cur.replaceAll(tmp, "").length() == 0) {
                        String encode = cur.length() / tmp.length() + "[" + dp[i][i + k] + "]";
                        if (encode.length() < dp[i][j].length()) {
                            dp[i][j] = encode;
                        }
                    }
                }
                for (int k = i; k < j; ++k) {
                    if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }
            }
        }
    }
    return dp[0][n - 1];
}





