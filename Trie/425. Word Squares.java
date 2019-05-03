
/*

Given a set of words (without duplicates), find all word squares you can build from them.
A sequence of words forms a valid word square if the kth row and column read the exact same string
For example, the word sequence ["ball","area","lead","lady"] forms a word square 
because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y

Example 1:
Input:
["area","lead","wall","lady","ball"]
Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Example 2:
Input:
["abat","baba","atan","atal"]
Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

*/

/*

Solution: build a trie for words and backtrack each position to form a valid matrix
O(nm+26^m),O(nm) where n is length of words array and m is length of each word

*/

class TrieNode {
    String word;
    TrieNode[] children;

    public TrieNode() {
        this.word = null;
        this.children = new TrieNode[26];
    }
}

public List<List<String>> wordSquares(String[] words) {
    List<List<String>> ans = new ArrayList<>();
    int n = words[0].length();
    TrieNode root = new TrieNode();
    for (String word : words) build(root, word);
    TrieNode[] roots = new TrieNode[n];
    Arrays.fill(roots, root);
    dfs(ans, roots, 0, 0);
    return ans;
}

private void build(TrieNode root, String word) {
    TrieNode cur = root;
    for (char c : word.toCharArray()) {
        if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
        cur = cur.children[c - 'a'];
    }
    cur.word = word;
}

private void dfs(List<List<String>> ans, TrieNode[] roots, int i, int j) {
    int n = roots.length;
    if (i == n) {
        List<String> tmp = new ArrayList<>();
        for (TrieNode root : roots) tmp.add(root.word);
        ans.add(tmp);
        return;
    }
    if (j < n) {
        TrieNode row = roots[i], col = roots[j];
        for (int k = 0; k < 26; ++k) {
            if (row.children[k] != null && col.children[k] != null) {
                roots[i] = row.children[k];
                roots[j] = col.children[k];
                dfs(ans, roots, i, j + 1);
            }
        }
        roots[i] = row;
        roots[j] = col;
    } else dfs(ans, roots, i + 1, i + 1);
}





