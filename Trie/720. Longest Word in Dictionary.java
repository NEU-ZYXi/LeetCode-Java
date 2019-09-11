
/*

Given a list of strings words representing an English Dictionary, 
find the longest word in words that can be built one character at a time by other words in words. 
If there is more than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.

Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".

Example 2:
Input: 
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation: 
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

*/

/*

O(nm),O(nm)

*/

class TrieNode {
    private TrieNode[] children;
    private String word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.word = "";
    }
}

public String longestWord(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }
    return dfs(root);
}

private String dfs(TrieNode root) {
    String ans = "";
    for (int i = 0; i < 26; ++i) {
        if (root.children[i] != null && root.children[i].word.length() != 0) {
            StringBuilder next = new StringBuilder();
            next.append((char)(i + 'a'));
            next.append(dfs(root.children[i]));
            if (next.length() > ans.length()) {
                ans = next.toString();
            }
        }
    }
    return ans;
}




