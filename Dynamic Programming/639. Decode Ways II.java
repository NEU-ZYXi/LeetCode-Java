
/*

A message containing letters from A-Z is being encoded to numbers using the following mapping way:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', 
which can be treated as one of the numbers from 1 to 9.
Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".

Example 2:
Input: "1*"
Output: 9 + 9 = 18

*/

/*

Solution: dp[i] means the number of decode ways for s[0...i]
          1. s[i-1]='*', dp[i]+=9*dp[i-1] since we have 9 more options to combine with previous ones
             s[i-1]>'0', dp[i]+=dp[i-1] 
                          |- s[i-1]='*', '11' to '19' and '21' to '26', dp[i]+=15*dp[i-2]
          2. s[i-2]='*', -|- s[i-1]<='6', s[i-2] can be '1' or '2', dp[i]+=2*dp[i-2]
                          |- otherwise, s[i-2] can only be '1', dp[i]+=dp[i-2]
                                       |- s[i-1]='*', dp[i]+=9*dp[i-2] if s[i-2]='1'
          3. s[i-2]='1' or s[i-2]='2' -|- s[i-1]='*', dp[i]+=6*dp[i-2] if s[i-2]='2'
                                       |- s[i-2]*10+s[i-1]<='26', dp[i]+=dp[i-2]
O(n),O(n)          

*/

public int numDecodings(String s) {
    int n = s.length(), MOD = 1000000007;
    long[] dp = new long[n + 1];
    dp[0] = 1;
    if (s.charAt(0) == '0') {
        return 0;
    }
    dp[1] = s.charAt(0) == '*' ? 9 : 1;
    for (int i = 2; i <= n; ++i) {
        char first = s.charAt(i - 2), second = s.charAt(i - 1);
        if (second == '*') {
            dp[i] = 9 * dp[i - 1];
        } else if (second > '0') {
            dp[i] = dp[i - 1];
        }
        if (first == '*') {
            if (second == '*') {
                dp[i] += 15 * dp[i - 2];
            } else if (second <= '6') {
                dp[i] += 2 * dp[i - 2];
            } else {
                dp[i] += dp[i - 2];
            }
        } else if (first == '1' || first == '2') {
            if (second == '*') {
                if (first == '1') {
                    dp[i] += 9 * dp[i - 2];
                } else {
                    dp[i] += 6 * dp[i - 2];
                } 
            } else if ((first - '0') * 10 + (second - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        dp[i] %= MOD;
    }
    return (int)dp[n];
}





