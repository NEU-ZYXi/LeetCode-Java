
/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

*/

/*

O(3^n),O(n)

*/

private String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

public List<String> letterCombinations(String digits) {
    List<String> ans = new ArrayList<>();
    if (digits.length() == 0)
        return ans;
    dfs(ans, new StringBuilder(), digits, 0);
    return ans;
}

private void dfs(List<String> ans, StringBuilder sb, String digits, int idx) {
    if (idx == digits.length()) {
        ans.add(sb.toString());
        return;
    }
    String str = strs[digits.charAt(idx) - '0'];
    for (int i = 0; i < str.length(); ++i) {
        sb.append(str.charAt(i));
        dfs(ans, sb, digits, idx + 1);
        sb.setLength(sb.length() - 1);
    }
}




