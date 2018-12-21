
/*

Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Example 1:
Input: s1 = "great", s2 = "rgeat"
Output: true

Example 2:
Input: s1 = "abcde", s2 = "caebd"
Output: false

*/

/*

Solution 1. to check two strings are scramble strings, use a bucket to check whether they have the same letters
            then check all its substring combinations to be scramble strings
            1. s1[0...i], s2[0...i] and s1[i...], s2[i...]
            2. s1[0...i], s2[n-i...] and s1[i...], s2[0...n-i]
O(4^n),O(n)            

*/

public boolean isScramble(String s1, String s2) {
    if (s1.equals(s2)) return true;
    int n = s1.length();
    int[] buckets = new int[256];
    for (int i = 0; i < n; ++i) {
        buckets[s1.charAt(i)]++;
        buckets[s2.charAt(i)]--;
    }
    for (int i = 0; i < buckets.length; ++i) {
        if (buckets[i] != 0) return false;
    }
    for (int i = 1; i < n; ++i) {
        if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) 
            return true;
        if (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, n - i))) 
            return true;
    }
    return false;
}


/*

Solution 2. dp[i][j][len] means whether s1[i...i+len-1] and s2[j...j+len-1] is scramble strings
            1. dp[i][j][k] which is s1[i...i+k-1] and s2[j...j+k-1]
               dp[i+k][j+k][len-k] which is s1[i+k...i+len-1] and s2[j+k...j+len-1]
               these two can form s1[i...i+len-1] and s2[j...j+len-1] which is dp[i][j][len]
            2. dp[i][j+len-k][k] which is s1[i...i+k-1] and s2[j+len-k...j+len-1]
               dp[i+k][j][len-k] which is s1[i+k...i+len-1] and s2[j...j+len-k-1]
               these two can form s1[i...i+len-1] and s2[j...j+len-1] which is dp[i][j][len]
O(n^4),O(n^3)               

*/

public boolean isScramble(String s1, String s2) {
    if (s1.equals(s2)) return true;
    int n = s1.length();
    boolean[][][] dp = new boolean[n][n][n + 1];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
    }
    for (int len = 1; len <= n; ++len) {
        for (int i = 0; i + len <= n; ++i) {
            for (int j = 0; j + len <= n; ++j) {
                for (int k = 1; k < len; ++k) 
                    dp[i][j][len] |= (dp[i][j][k] && dp[i + k][j + k][len - k]) ||
                                     (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
            }
        }
    }
    return dp[0][0][n];
}







