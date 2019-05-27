
/*

Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word 
following rules below.
Begin with the first character and then the number of characters abbreviated, which followed by the last character.
If there are any conflict, that is more than one words share the same abbreviation, 
a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. 
In other words, a final abbreviation cannot map to more than one original words.
If the abbreviation doesn't make the word shorter, then keep it as original.

Example:
Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]

*/

/*

Solution 1: keep increasing prefix until no overlaps
O(mn^2),O(n) where n is length of dict and m is length of words

*/

public List<String> wordsAbbreviation(List<String> dict) {
    int n = dict.size();
    List<String> ans = new ArrayList<>();
    int[] prefix = new int[n];
    for (int i = 0; i < n; ++i) {
        prefix[i] = 1;
        ans.add(makeAbbr(dict.get(i), 1));
    }
    for (int i = 0; i < n; ++i) {
        while (true) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; ++j) {
                if (ans.get(i).equals(ans.get(j))) {
                    set.add(j);
                }
            }
            if (set.isEmpty()) {
                break;
            }
            set.add(i);
            for (int idx : set) {
                ans.set(idx, makeAbbr(dict.get(idx), ++prefix[idx]));
            }
        }
    }
    return ans;
}

private String makeAbbr(String s, int start) {
    int n = s.length();
    if (start >= n - 2) {
        return s;
    }
    return s.substring(0, start) + s.substring(start, n - 1).length() + s.charAt(n - 1);
}


/*

Solution 2: map words into different groups based on their abbreviations
            for each group, build a trie for words, and for each word, find the deepest node which is the last prefix index
            reconstruct the abbreviation for each word
O(nmk),O(nmk) where n is number of abbreviation groups and m is average number of words in each group and k is length of words            

*/

class TrieNode {    
    private int cnt;
    private TrieNode[] children;

    public TrieNode() {
        this.cnt = 0;
        this.children = new TrieNode[26];
    }

    private void build(List<String> dict, List<Integer> idx) {
        for (int i : idx) {
            String s = dict.get(i);
            TrieNode cur = this;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
                cur.cnt++;
            }
        }
    }
}

public List<String> wordsAbbreviation(List<String> dict) {
    List<String> ans = new ArrayList<>(dict);
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < dict.size(); ++i) {
        String key = makeAbbr(dict.get(i));
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(i);
    }
    for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
        solve(ans, dict, entry.getKey(), entry.getValue());
    }
    return ans;
}

private String makeAbbr(String s) {
    int n = s.length();
    if (n <= 3) {
        return s;
    }
    return s.charAt(0) + String.valueOf(n - 2) + s.charAt(n - 1);
}

private void solve(List<String> ans, List<String> dict, String key, List<Integer> idx) {
    if (idx.size() == 1) {
        ans.set(idx.get(0), key);
    } else {
        TrieNode root = new TrieNode();
        root.build(dict, idx);
        for (int i : idx) {
            String s = dict.get(i);
            TrieNode cur = root;
            int prefix = 0, n = s.length();
            while (prefix < n && cur.children[s.charAt(prefix) - 'a'].cnt > 1) {
                cur = cur.children[s.charAt(prefix) - 'a'];
                prefix++;
            }
            if (prefix >= n - 3) {
                ans.set(i, s);
            } else {
                String newKey = s.substring(0, prefix + 1) + String.valueOf(n - prefix - 2) + s.charAt(n - 1);
                ans.set(i, newKey);
            }
        }
    }
}





