
/*

In English, we have a concept called root, 
which can be followed by some other words to form another longer word - let's call this word successor. 
For example, the root an, followed by other, which can form another word another.
Now, given a dictionary consisting of many roots and a sentence. 
You need to replace all the successor in the sentence with the root forming it.
If a successor has many roots can form it, replace it with the root with the shortest length.
You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

*/

/*

O(nm),O(nm)

*/

class TrieNode {
    private TrieNode[] children;
    private String word;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.word = null;
    }
}

public String replaceWords(List<String> dict, String sentence) {
    TrieNode root = new TrieNode();
    StringBuilder ans = new StringBuilder();
    for (String s : dict) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = s;
    }
    for (String s : sentence.split("\\s+")) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null || cur.word != null) {
                break;
            }
            cur = cur.children[c - 'a'];
        }
        ans.append(" ").append(cur.word != null ? cur.word : s);
    }
    return ans.substring(1).toString();
}




