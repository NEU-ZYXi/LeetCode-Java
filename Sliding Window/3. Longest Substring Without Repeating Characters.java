
/*

Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

/*

O(n),O(n)

*/

public int lengthOfLongestSubstring(String s) {
    int ans = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0, j = 0; j < s.length(); ++j) {
        if (map.containsKey(s.charAt(j))) {
            i = Math.max(i, map.get(s.charAt(j)) + 1);
        }
        map.put(s.charAt(j), j);
        ans = Math.max(ans, j - i + 1);
    }
    return ans;
}





