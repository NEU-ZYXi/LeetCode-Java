
/*

Implement a magic directory with buildDict, and search methods.
For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
For the method search, you'll be given a word, and judge whether 
if you modify exactly one character into another character in this word, 
the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False

*/

/*

Solution 1: O(nm),O(n)

*/

class MagicDictionary {
    private Map<Integer, List<String>> map;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            int n = s.length();
            map.putIfAbsent(n, new ArrayList<>());
            map.get(n).add(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int n = word.length();
        if (!map.containsKey(n)) {
            return false;
        }
        for (String s : map.get(n)) {
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (s.charAt(i) != word.charAt(i)) {
                    cnt++;
                    if (cnt == 2) {
                        break;
                    }
                }
            }
            if (cnt == 1) {
                return true;
            }
        }
        return false;
    }
}


/*

Solution 2: O(nm),O(nm)

*/

class MagicDictionary {
    class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return search(root, word, 0, false);
    }
    
    private boolean search(TrieNode cur, String s, int idx, boolean isModified) {
        if (idx == s.length()) {
            return isModified && cur.isWord;
        }
        char c = s.charAt(idx);
        if (isModified) {
            if (cur.children[c - 'a'] != null) {
                return search(cur.children[c - 'a'], s, idx + 1, isModified);
            }
            return false;
        } else {
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (cur.children[ch - 'a'] != null) {
                    if (c == ch) {
                        if (search(cur.children[ch -'a'], s, idx + 1, false)) {
                            return true;
                        }
                    } else {
                        if (search(cur.children[ch - 'a'], s, idx + 1, true)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}




