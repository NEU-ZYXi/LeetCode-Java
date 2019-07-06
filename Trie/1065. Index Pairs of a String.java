
/*

Given a text string and words (a list of strings), 
return all index pairs [i, j] so that the substring text[i]...text[j] is in the list of words.

Example 1:
Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
Output: [[3,7],[9,13],[10,17]]

Example 2:
Input: text = "ababa", words = ["aba","ab"]
Output: [[0,1],[0,2],[2,3],[2,4]]
Explanation: 
Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].

*/

/*

Solution 1: O(n^2),O(n)

*/

public int[][] indexPairs(String text, String[] words) {
    List<int[]> ans = new ArrayList<>();
    Set<String> dict = new HashSet<>(Arrays.asList(words));
    for (int i = 0, j = 0; j <= text.length(); ++j) {
        if (j == text.length()) {
            j = i;
            i++;
            continue;
        }
        String cur = text.substring(i, j + 1);
        if (dict.contains(cur)) {
            ans.add(new int[] {i, j});
        }
    }
    return ans.toArray(new int[ans.size()][2]);
}


/*

Solution 2: build a trie, and use two pointers to check each substring whether it's in the trie
O(nm),O(nm) where n is length of text and m is average length of words

*/

class TrieNode {
    private TrieNode[] children;
    private boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

public int[][] indexPairs(String text, String[] words) {
    TrieNode root = new TrieNode();
    build(root, words);
    List<int[]> ans = new ArrayList<>();
    int n = text.length();
    for (int i = 0; i < n; ++i) {
        TrieNode cur = root;
        char c = text.charAt(i);
        int j = i;
        while (j < n && cur.children[c - 'a'] != null) {
            cur = cur.children[c - 'a'];
            if (cur.isWord) {
                ans.add(new int[] {i, j});
            }
            j++;
            if (j < n) {
                c = text.charAt(j);
            }
        }
    }
    return ans.toArray(new int[ans.size()][2]);
}

private void build(TrieNode root, String[] words) {
    for (String word : words) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
}



