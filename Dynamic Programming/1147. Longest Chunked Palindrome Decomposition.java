
/*

Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:
Each a_i is a non-empty string;
Their concatenation a_1 + a_2 + ... + a_k is equal to text;
For all 1 <= i <= k,  a_i = a_{k+1 - i}.

Example 1:
Input: text = "ghiabcdefhelloadamhelloabcdefghi"
Output: 7
Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".

Example 2:
Input: text = "merchant"
Output: 1
Explanation: We can split the string on "(merchant)".

Example 3:
Input: text = "antaprezatepzapreanta"
Output: 11
Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".

Example 4:
Input: text = "aaa"
Output: 3
Explanation: We can split the string on "(a)(a)(a)".

*/

/*

Solution 1: for each prefix substring, check whether we could find the same from suffix, and recursively count the middle substring
O(n^2),(n)

*/

public int longestDecomposition(String text) {
    Map<String, Integer> memo = new HashMap<>();
    return dfs(text, memo);
}

private int dfs(String s, Map<String, Integer> memo) {
    int ans = 1, n = s.length();
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    }
    if (memo.containsKey(s)) {
        return memo.get(s);
    }
    for (int i = 1; i <= n / 2; ++i) {
        String cur = s.substring(0, i);
        if (cur.equals(s.substring(n - i))) {
            String next = s.substring(i, n - i);
            ans = Math.max(dfs(next, memo) + 2, ans);
        }
    }
    memo.put(s, ans);
    return ans;
}


/*

Solution 2: use two pointers to build prefix and suffix substring, if they are equal, greedily have a new decomposition
O(n^2),O(1)

*/

public int longestDecomposition(String text) {
    int ans = 0, n = text.length();
    String left = "", right = "";
    for (int i = 0, j = n - 1; i < n && j >= 0; ++i, --j) {
        left = left + text.charAt(i);
        right = text.charAt(j) + right;
        if (left.equals(right)) {
            ans++;
            left = "";
            right = "";
        }
    }
    return ans;
}




