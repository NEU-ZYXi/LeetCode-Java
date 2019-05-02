
/*

Given a string that consists of only uppercase English letters, 
you can replace any letter in the string with another letter at most k times. 
Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Example 1:
Input:
s = "ABAB", k = 2
Output:
4
Explanation:
Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input:
s = "AABABBA", k = 1
Output:
4
Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.

*/

/*

Solution: use sliding window to track current valid substring with at most k replacements
          if the size of current window j-i+1-max>k which means k replacements cannot fill the window with only one character,
          then we need to shrink the window, find the longest window on the fly
O(n),O(1)          

*/

public int characterReplacement(String s, int k) {
    int ans = 0, max = 0, n = s.length();
    int[] buckets = new int[128];
    for (int i = 0, j = 0; j < n; ++j) {
        char c = s.charAt(j);
        buckets[c]++;
        max = Math.max(max, buckets[c]);
        if (j - i + 1 - max > k) {
            buckets[s.charAt(i)]--;
            i++;
        }
        ans = Math.max(ans, j - i + 1);
    }
    return ans;
}





