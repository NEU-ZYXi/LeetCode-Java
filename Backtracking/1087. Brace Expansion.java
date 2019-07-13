
/*

A string S represents a list of words.
Each letter in the word has 1 or more options.  
If there is one option, the letter is represented as is.  
If there is more than one option, then curly braces delimit the options.  
For example, "{a,b,c}" represents options ["a", "b", "c"].
For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
Return all words that can be formed in this manner, in lexicographical order.

Example 1:
Input: "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]

Example 2:
Input: "abcd"
Output: ["abcd"]

*/

/*

O(n^mlog(n^m)),O(n^m) where n is number of characters in each group and m is number of groups

*/

public String[] expand(String S) {
    if (S.length() == 0) {
        return new String[0];
    }
    List<String> ans = new ArrayList<>();
    List<List<Character>> chars = new ArrayList<>();
    boolean brace = false;
    for (char c : S.toCharArray()) {
        if (c == '{') {
            brace = true;
            chars.add(new ArrayList<>());
        } else if (c == '}') {
            brace = false;
        } else if (Character.isLetter(c)) {
            if (!brace) {
                chars.add(new ArrayList<>());
            }
            chars.get(chars.size() - 1).add(c);
        }
    }
    dfs(ans, chars, new StringBuilder(), 0);
    Collections.sort(ans);
    return ans.toArray(new String[0]);
}

private void dfs(List<String> ans, List<List<Character>> chars, StringBuilder sb, int idx) {
    if (sb.length() == chars.size()) {
        ans.add(sb.toString());
        return;
    }
    for (int i = 0; i < chars.get(idx).size(); ++i) {
        sb.append(chars.get(idx).get(i));
        dfs(ans, chars, sb, idx + 1);
        sb.setLength(sb.length() - 1);
    }
}



