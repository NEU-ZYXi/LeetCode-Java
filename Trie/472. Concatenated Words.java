
/*

Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

*/

/*

Solution 1: for each word, check whether it could separated into words in the dict
O(nm),O(n) where n is the length of words array and m is the average length of each word

*/

public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> ans = new ArrayList<>();
    Set<String> dict = new HashSet<>(Arrays.asList(words));
    for (String word : words) {
        if (dfs(dict, word)) {
            ans.add(word);
        }
    }
    return ans;
}

private boolean dfs(Set<String> dict, String s) {
    for (int i = 1; i < s.length(); ++i) {
        String prefix = s.substring(0, i);
        if (dict.contains(prefix)) {
            String suffix = s.substring(i);
            if (dict.contains(suffix) || dfs(dict, suffix)) {
                return true;
            }
        }
    }
    return false;
}


/*

Solution 2: build a trie for words, for each word, go through its path
            if we find one word, DFS from the root for remaining substring to check if it can be separated 
            otherwise, keep going deep, note to check if the last word is itself
O(nm),O(nm)            

*/

class TrieNode {
        
    private String word;
    private TrieNode[] children;

    public TrieNode() {
        this.word = null;
        this.children = new TrieNode[26];
    }
}

public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> ans = new ArrayList<>();
    TrieNode root = new TrieNode();
    for (String word : words) {
        if (word.length() == 0) continue;
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }
    for (String word : words) {
        if (dfs(root, root, word, 0)) {
            ans.add(word);
        }
    }
    return ans;
}

private boolean dfs(TrieNode root, TrieNode cur, String s, int idx) {
    if (idx == s.length()) {
        return cur.word != null && !cur.word.equals(s);
    }
    char c = s.charAt(idx);
    if (cur.children[c - 'a'] == null) {
        return false;
    }
    if (cur.children[c - 'a'].word != null) {
        if (dfs(root, root, s, idx + 1)) {
            return true;
        }
    }
    return dfs(root, cur.children[c - 'a'], s, idx + 1);
}




