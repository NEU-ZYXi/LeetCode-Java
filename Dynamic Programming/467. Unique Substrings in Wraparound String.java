
/*

Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", 
so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. 
Your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
Note: p consists of only lowercase English letters and the size of p might be over 10000.

Example 1:
Input: "a"
Output: 1
Explanation: Only the substring "a" of string "a" is in the string s.

Example 2:
Input: "cac"
Output: 2
Explanation: There are two substrings "a", "c" of string "cac" in the string s.

Example 3:
Input: "zab"
Output: 6
Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.

*/

/*

O(n),O(1)

*/

public int findSubstringInWraproundString(String p) {
    int ans = 0, cnt = 1;
    int[] buckets = new int[26];
    for (int i = 0; i < p.length(); ++i) {
        char c = p.charAt(i);
        if (i > 0 && (c == p.charAt(i - 1) + 1 || p.charAt(i - 1) - c == 25)) cnt++;
        else cnt = 1;
        buckets[c - 'a'] = Math.max(buckets[c - 'a'], cnt);
    }
    for (int i = 0; i < buckets.length; ++i) ans += buckets[i];
    return ans;
}




