
/*

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Note: The input string may contain letters other than the parentheses ( and ).

Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:
Input: ")("
Output: [""]

*/

/*

Solution: count the left and right parentheses that need to be removed
          backtrack to rebuild the valid parentheses, use count the track the valid of current parentheses
O(2^n),O(n)          

*/

public List<String> removeInvalidParentheses(String s) {
    int l = 0, r = 0;
    for (int i = 0; i < s.length(); ++i) {
        if (s.charAt(i) == '(') l++;
        else if (s.charAt(i) == ')') {
            if (l > 0) l--;
            else r++;
        }
    }
    Set<String> ans = new HashSet<>();
    dfs(ans, new StringBuilder(), s, l, r, 0, 0);
    return new ArrayList<>(ans);
}

private void dfs(Set<String> ans, StringBuilder tmp, String s, int l, int r, int cnt, int idx) {
    if (l < 0 || r < 0 || cnt < 0) return;
    if (idx == s.length()) {
        if (l == 0 && r == 0 && cnt == 0) ans.add(tmp.toString());
        return;
    }
    char c = s.charAt(idx);
    if (c == '(') {
        dfs(ans, tmp.append(c), s, l, r, cnt + 1, idx + 1);
        tmp.setLength(tmp.length() - 1);
        dfs(ans, tmp, s, l - 1, r, cnt, idx + 1);
    } else if (c == ')') {
        dfs(ans, tmp.append(c), s, l, r, cnt - 1, idx + 1);
        tmp.setLength(tmp.length() - 1);
        dfs(ans, tmp, s, l, r - 1, cnt, idx + 1);
    } else {
        dfs(ans, tmp.append(c), s, l, r, cnt, idx + 1);
        tmp.setLength(tmp.length() - 1);
    }
}




