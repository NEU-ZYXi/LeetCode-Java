
/*

Given a string s, return all the palindromic permutations (without duplicates) of it. 
Return an empty list if no palindromic permutation could be form.

Example 1:
Input: "aabb"
Output: ["abba", "baab"]

Example 2:
Input: "abc"
Output: []

*/

/*

Solution: 1. count each characters, find the middle one
          2. calculate the left part length
          3. do backtracking, append each available character to the palindrome string
O(26^n),O(n)          

*/

public List<String> generatePalindromes(String s) {
    int[] buckets = new int[128];
    int cnt = 0;
    for (int i = 0; i < s.length(); ++i) {
        buckets[s.charAt(i)]++;
        if (buckets[s.charAt(i)] % 2 == 1) cnt++;
        else cnt--;
    }
    List<String> ans = new ArrayList<>();
    if (cnt > 1) return ans;
    String mid = "";
    int len = 0;
    for (int i = 0; i < buckets.length; ++i) {
        if (buckets[i] > 0) {
            if (buckets[i] % 2 == 1) mid = (char)i + "";
            buckets[i] /= 2;
            len += buckets[i];
        }
    }
    dfs(ans, new StringBuilder(), buckets, mid, len);
    return ans;
}

private void dfs(List<String> ans, StringBuilder tmp, int[] buckets, String mid, int len) {
    if (tmp.length() == len) {
        String rev = new StringBuilder(tmp).reverse().toString();
        tmp = tmp.append(mid).append(rev);
        ans.add(tmp.toString());
        return;
    }
    for (int i = 0; i < buckets.length; ++i) {
        if (buckets[i] > 0) {
            buckets[i]--;
            int prev = tmp.length();
            tmp.append((char)i);
            dfs(ans, tmp, buckets, mid, len);
            tmp.setLength(prev);
            buckets[i]++;
        }
    }
}




