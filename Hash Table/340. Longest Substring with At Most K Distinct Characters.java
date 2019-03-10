
/*

Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.

Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

*/

/*

O(n),O(26)

*/

public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int ans = 0, cnt = 0;
    for (int i = 0, j = 0; j < s.length(); ++j) {
        char r = s.charAt(j);
        if (!map.containsKey(r)) {
            map.put(r, 1);
            cnt++;
        } else map.put(r, map.get(r) + 1);
        if (cnt <= k) ans = Math.max(ans, j - i + 1);
        while (cnt == k + 1) {
            char l = s.charAt(i);
            map.put(l, map.get(l) - 1);
            if (map.get(l) == 0) {
                map.remove(l);
                cnt--;
            }
            i++;
        }
    }
    return ans;
}


public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int[] buckets = new int[128];
    int ans = 0, cnt = 0;
    for (int i = 0, j = 0; j < s.length(); ++j) {
        char r = s.charAt(j);
        if (buckets[r] == 0) cnt++;
        buckets[r]++;
        if (cnt <= k) ans = Math.max(ans, j - i + 1);
        while (cnt == k + 1) {
            char l = s.charAt(i);
            buckets[l]--;
            if (buckets[l] == 0) cnt--;
            i++;
        }
    }
    return ans;
}



