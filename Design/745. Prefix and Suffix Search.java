
/*

Given many words, words[i] has weight i.
Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). 
It will return the word with given prefix and suffix with maximum weight. 
If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1

*/

/*

Solution 1: constructor O(1), f O(nm) where n is length of words array and m is average length of words

*/

class WordFilter {
    private String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }
    
    public int f(String prefix, String suffix) {
        for (int i = words.length - 1; i >= 0; --i) {
            if (words[i].startsWith(prefix) && words[i].endsWith(suffix)) {
                return i;
            }
        }
        return -1;
    }
}


/*

Solution 2: use trie we only know children nodes, so for each word, build suffix+'{'+word in trie
            then we can use trie to search for prefix and suffix with this string format
            use '{' is because '{' is after 'z'
            weight of node will be updated with larger value so we can ensure the max weight for each node
constructor O(nm^2), f O(m) where n is length of words array and m is average length of words           

*/

class WordFilter {
    class TrieNode {
        private TrieNode[] children;
        private int weight;
        
        public TrieNode() {
            this.children = new TrieNode[27];
        }
        
        public void add(String s, int weight) {
            TrieNode cur = this;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
                cur.weight = weight;
            }
        }
        
        public int find(String s) {
            TrieNode cur = this;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return -1;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.weight;
        }
    }
    
    private TrieNode root;

    public WordFilter(String[] words) {
        this.root = new TrieNode();
        int n = words.length;
        for (int i = 0; i < n; ++i) {
            String word = words[i];
            for (int j = 0; j <= word.length(); ++j) {
                root.add(word.substring(j) + "{" + word, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return root.find(suffix + "{" + prefix);
    }
}





