
/*

Implement a MapSum class with insert, and sum methods.
For the method insert, you'll be given a pair of (string, integer). 
The string represents the key and the integer represents the value. 
If the key already existed, then the original key-value pair will be overridden to the new one.
For the method sum, you'll be given a string representing the prefix, 
and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5

*/

/*

O(nm),O(nm)

*/

class MapSum {
    class TrieNode {
        private TrieNode[] children;
        private String word;
        private int cnt;
        
        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = null;
            this.cnt = 0;
        }
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = key;
        cur.cnt = val;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }
        return dfs(cur);
    }
    
    private int dfs(TrieNode cur) {
        int ans = cur.cnt;
        for (TrieNode next : cur.children) {
            if (next != null) {
                ans += dfs(next);
            }
        }
        return ans;
    }
}




