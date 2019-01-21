
/*

Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]

*/

/*

Solution 1: O(n*2^n),O(n)

*/

public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), s, 0);
    return ans;
}

private void dfs(List<List<String>> ans, List<String> tmp, String s, int idx) {
    if (idx == s.length()) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    for (int i = idx; i < s.length(); ++i) {
        String str = s.substring(idx, i + 1);
        if (isPalindrome(str)) {
            tmp.add(str);
            dfs(ans, tmp, s, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

private boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
        if (s.charAt(l) != s.charAt(r)) return false;
        l++;
        r--;
    }
    return true;
}


/*

Solution 2: O(2^n),O(n^2)

*/

public List<List<String>> partition(String s) {
    int n = s.length();
    List<List<String>> ans = new ArrayList<>();
    boolean[][] dp = new boolean[n][n];
    for (int i = 0; i < n; ++i) {
        for (int j = i; j >= 0; --j) {
            if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) dp[j][i] = true;
        }
    }
    dfs(ans, new ArrayList<>(), s, dp, 0);
    return ans;
}

private void dfs(List<List<String>> ans, List<String> tmp, String s, boolean[][] dp, int idx) {
    if (idx == s.length()) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    for (int i = idx; i < s.length(); ++i) {
        if (dp[idx][i]) {
            tmp.add(s.substring(idx, i + 1));
            dfs(ans, tmp, s, dp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}




