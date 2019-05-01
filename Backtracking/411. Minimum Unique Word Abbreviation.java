
/*

A string such as "word" contains the following abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Given a target string and a set of strings in a dictionary, 
find an abbreviation of this target string with the smallest possible length 
such that it does not conflict with abbreviations of the strings in the dictionary.
Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.
Note:
In the case of multiple answers as shown in the second example below, you may return any one of them.
Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.

Examples:
"apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")
"apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").

*/

/*

Solution: 1. build a trie for all strings in dictionary
          2. generate all valid abbreviations for the target string
          3. sort the abbreviations and check if it matchs any string in the trie, if not, it's the minimum one
O(nm+2^n+n*2^n) where n is the length of target string and m is the length of dictionary          

*/

class TrieNode {
    String word;
    TrieNode[] children = new TrieNode[26];
}

private TrieNode root;

public String minAbbreviation(String target, String[] dictionary) {
    if (target.length() == 0) return "";
    if (dictionary.length == 0) return target.length() + "";
    int n = target.length();
    this.root = new TrieNode();
    build(dictionary, n);
    List<String> abbr = new ArrayList<>();
    dfs(abbr, new StringBuilder(), target, 0, 0);
    Collections.sort(abbr, new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    });
    for (String s : abbr) {
        if (!findMatch(root, s, 0, 0)) return s;
    }
    return "";
}

private void build(String[] dict, int n) {
    for (String s : dict) {
        if (s.length() != n) continue;
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.word = s;
    }
}

private void dfs(List<String> ans, StringBuilder cur, String target, int idx, int cnt) {
    if (idx == target.length()) {
        if (cnt > 0) cur.append(cnt);
        ans.add(cur.toString());
        return;
    }
    int len = cur.length();
    dfs(ans, cur, target, idx + 1, cnt + 1);
    cur.setLength(len);
    dfs(ans, cur.append(cnt > 0 ? cnt : "").append(target.charAt(idx)), target, idx + 1, 0);
    cur.setLength(len);
}

private boolean findMatch(TrieNode root, String s, int idx, int cnt) {
    int n = s.length();
    if (root == null) return false;
    if (cnt != 0) {
        for (int i = 0; i < 26; ++i) {
            if (findMatch(root.children[i], s, idx, cnt - 1)) return true;
        }
        return false;
    }
    if (idx == n) return root.word != null;
    while (idx < n) {
        char c = s.charAt(idx);
        if (Character.isDigit(c)) {
            cnt = cnt * 10 + (c - '0');
            idx++;
        } else break;
    }
    if (cnt == 0) return findMatch(root.children[s.charAt(idx) - 'a'], s, idx + 1, cnt);
    else return findMatch(root, s, idx, cnt);
}




