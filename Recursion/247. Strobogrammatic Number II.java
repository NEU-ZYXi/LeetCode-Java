
/*

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Find all strobogrammatic numbers that are of length = n.

Example:
Input:  n = 2
Output: ["11","69","88","96"]

*/

/*

O(5^n),O(n)

*/

private char[][] pairs = new char[][] {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
public List<String> findStrobogrammatic(int n) {
    List<String> ans = new ArrayList<>();
    dfs(ans, new char[n], 0, n - 1);
    return ans;
}

private void dfs(List<String> ans, char[] tmp, int l, int r) {
    if (l > r) {
        ans.add(new String(tmp));
        return;
    }
    for (char[] pair : pairs) {
        tmp[l] = pair[0];
        tmp[r] = pair[1];
        if (l == r && pair[0] != pair[1]) continue;
        if (tmp.length > 1 && tmp[0] == '0') continue;
        dfs(ans, tmp, l + 1, r - 1);
    }
}




