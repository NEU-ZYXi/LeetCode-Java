
/*

Write a function to generate the generalized abbreviations of a word. 
Note: The order of the output does not matter.

Example:
Input: "word"
Output:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

*/

/*

O(2^n),O(n)

*/

public List<String> generateAbbreviations(String word) {
    List<String> ans = new ArrayList<>();
    dfs(ans, new StringBuilder(), word, 0, 0);
    return ans;
}

private void dfs(List<String> ans, StringBuilder tmp, String word, int idx, int cnt) {
    if (idx == word.length()) {
        if (cnt > 0) tmp.append(cnt);
        ans.add(tmp.toString());
        return;
    }
    int len = tmp.length();
    dfs(ans, tmp, word, idx + 1, cnt + 1);
    tmp.setLength(len);
    dfs(ans, tmp.append(cnt > 0 ? cnt : "").append(word.charAt(idx)), word, idx + 1, 0);
    tmp.setLength(len);
}




