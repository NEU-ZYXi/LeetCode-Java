
/*

Implement the StreamChecker class as follows:
StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, 
including this letter just queried) spell one of the words in the given list. 

Example:
StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist

*/

/*

Solution: build a trie for reversed string, and check the current reversed string in stream
O(nm),O(nm) where n is length of query and m is length of words

*/

class StreamChecker {
    class TrieNode {
        private boolean isWord;
        private TrieNode[] children;
        
        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    private StringBuilder sb;

    public StreamChecker(String[] words) {
        this.root = new TrieNode();
        this.sb = new StringBuilder();
        build(words);
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode cur = root;
        for (int i = sb.length() - 1; i >= 0 && cur != null; --i) {
            char c = sb.charAt(i);
            cur = cur.children[c - 'a'];
            if (cur != null && cur.isWord) {
                return true;
            }
        }
        return false;
    }
    
    private void build(String[] words) {
        for (String s : words) {
            TrieNode cur = root;
            for (int i = s.length() - 1; i >= 0; --i) {
                char c = s.charAt(i);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
    }
}




