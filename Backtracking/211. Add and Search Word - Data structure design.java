
/*

Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
A . means it can represent any one letter.

Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

*/

/*

O(26n),O(26n)

*/

class WordDictionary {
    
    class TrieNode {
        private String word;
        private TrieNode[] children;
        
        public TrieNode() {
            this.word = null;
            this.children = new TrieNode[26];
        }
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root;
        return dfs(cur, word, 0);
    }
    
    private boolean dfs(TrieNode root, String word, int idx) {
        if (idx == word.length()) return root.word != null;
        char c = word.charAt(idx);
        if (c == '.') {
            for (int i = 0; i < 26; ++i) {
                if (root.children[i] != null) {
                    if (dfs(root.children[i], word, idx + 1)) return true;
                }
            }
        } else {
            if (root.children[c - 'a'] == null) return false;
            return dfs(root.children[c - 'a'], word, idx + 1);
        }
        return false;
    }
}




