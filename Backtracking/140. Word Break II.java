
/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

*/

/*

O(branch^depth+words concatenation in each depth)
O(n^(s/m)+(s/m)^2), where n is the length of word dict, m is the average length of words, s is the length of string

*/

public List<String> wordBreak(String s, List<String> wordDict) {
    Map<String, List<String>> memo = new HashMap<>();
    return dfs(s, memo, wordDict);
}

private List<String> dfs(String s, Map<String, List<String>> memo, List<String> wordDict) {
    if (memo.containsKey(s)) return memo.get(s);
    List<String> ans = new ArrayList<>();
    if (s.length() == 0) {
        ans.add("");
        return ans;
    }
    for (String word : wordDict) {
        if (s.startsWith(word)) {
            List<String> nxt = dfs(s.substring(word.length()), memo, wordDict);
            for (String tmp : nxt) ans.add(word + (tmp.length() == 0 ? "" : " " + tmp));
        }
    }
    memo.put(s, ans);
    return ans;
}



