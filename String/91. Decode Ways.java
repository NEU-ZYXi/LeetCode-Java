
/*

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

*/

/*

Solution: dp[i] means the number of decode ways for s[0...i]
          if s[i]!='0' which means we could decode s[0...i] as s[0...i-1] and s[i], dp[i]=dp[i-1]
          if s[i-1]!='0' and s[i-1,i]<='26' which means we could decode s[0...i] as s[0...i-2] and s[i-1,i], dp[i]+=dp[i-2]
O(n),O(n)          

*/

public int numDecodings(String s) {
    int n = s.length();
    if (n == 0) return 0;
    int[] dp = new int[n];
    dp[0] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 1; i < n; ++i) {
        if (s.charAt(i) != '0') dp[i] = dp[i - 1];
        if (s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) dp[i] += i > 1 ? dp[i - 2] : 1;
    }
    return dp[n - 1];
}


public int numDecodings(String s) {
    int n = s.length();
    if (n == 0) return 0;
    int dp1 = 0, dp2 = 0, cur = 0;
    dp1 = s.charAt(0) == '0' ? 0 : 1;
    if (n == 1) return dp1;
    for (int i = 1; i < n; ++i) {
        cur = 0;
        if (s.charAt(i) != '0') cur = dp1;
        if (s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i - 1, i + 1)) <= 26) cur += i > 1 ? dp2 : 1;
        dp2 = dp1;
        dp1 = cur;
    }
    return cur;
}




