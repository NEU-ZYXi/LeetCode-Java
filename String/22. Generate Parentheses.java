
/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

/*

O(2^n),O(n)

*/

public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    dfs(ans, new StringBuilder(), n, 0, 0);
    return ans;
}

private void dfs(List<String> ans, StringBuilder sb, int n, int left, int right) {
    if (left == n && right == n) {
        ans.add(sb.toString());
        return;
    }
    if (left < n) {
        sb.append("(");
        dfs(ans, sb, n, left + 1, right);
        sb.setLength(sb.length() - 1);
    }
    if (right < left) {
        sb.append(")");
        dfs(ans, sb, n, left, right + 1);
        sb.setLength(sb.length() - 1);
    }
}



