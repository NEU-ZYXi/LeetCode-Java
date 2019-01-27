
/*

Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

Example 2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.

*/

/*

O(n),O(1)

*/

public int lengthOfLongestSubstringTwoDistinct(String s) {
    int[] buckets = new int[128];
    int ans = 0, cnt = 0;
    for (int i = 0, j = 0; j < s.length(); ++j) {
        char right = s.charAt(j);
        if (buckets[right] == 0) cnt++;
        buckets[right]++;
        while (cnt > 2) {
            char left = s.charAt(i);
            buckets[left]--;
            if (buckets[left] == 0) cnt--;
            i++;
        }
        ans = Math.max(ans, j - i + 1);
    }
    return ans;
}




