
/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
             
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

*/

/*

Solution: dp[i] is whether s[0...i] can be breaked
          dp[i] is true when dp[j-1] is true and s[j...i] is in the word list
O(n^2),O(n)

*/

public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] dp = new boolean[n];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j <= i; ++j) {
            if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1])) dp[i] = true;
        }
    }
    return dp[n - 1];
}



