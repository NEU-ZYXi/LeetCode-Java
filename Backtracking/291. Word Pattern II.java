
/*

Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Example 1:
Input: pattern = "abab", str = "redblueredblue"
Output: true

Example 2:
Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
Output: true

Example 3:
Input: pattern = "aabb", str = "xyzabcxzyabc"
Output: false

*/

/*

O(n*S(n,m)),O(S(n,m)), where S(n,m) is Stirling set number, S(n,m)≈m^n

*/

public boolean wordPatternMatch(String pattern, String str) {
    Map<Character, String> map = new HashMap<>();
    Set<String> vis = new HashSet<>();
    return dfs(map, vis, pattern, 0, str, 0);
}

private boolean dfs(Map<Character, String> map, Set<String> vis, String pattern, int i, String str, int j) {
    if (i == pattern.length() && j == str.length()) return true;
    if (i == pattern.length() || j == str.length()) return false;
    char c = pattern.charAt(i);
    if (map.containsKey(c)) {
        String s = map.get(c);
        if (!str.startsWith(s, j)) return false;
        return dfs(map, vis, pattern, i + 1, str, j + s.length());
    }
    for (int k = j; k < str.length(); ++k) {
        String s = str.substring(j, k + 1);
        if (vis.contains(s)) continue;
        vis.add(s);
        map.put(c, s);
        if (dfs(map, vis, pattern, i + 1, str, k + 1)) return true;
        map.remove(c);
        vis.remove(s);
    }
    return false;
}




