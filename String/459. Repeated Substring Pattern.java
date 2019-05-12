
/*

Given a non-empty string check if it can be constructed by taking a substring of it 
and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

*/

/*

O(n^2),O(1)

*/

public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    for (int i = 1; i <= n / 2; ++i) {
        if (n % i == 0) {
            int total = n / i, cnt = 1;
            String pattern = s.substring(0, i);
            while (cnt < total) {
                String cur = s.substring(i * cnt, i * (cnt + 1));
                if (!cur.equals(pattern)) break;
                cnt++;
            }
            if (total == cnt) return true;
        }
    }
    return false;
}




