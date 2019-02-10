
/*

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

Example:
Input: low = "50", high = "100"
Output: 3 
Explanation: 69, 88, and 96 are three strobogrammatic numbers.

*/

/*

Solution: for each length of string between low and high, construct a valid strobogrammatic string and check if it's in scope
O(5^n),O(n)

*/

private char[][] pairs = new char[][] {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
public int strobogrammaticInRange(String low, String high) {
    int[] ans = new int[1];
    for (int i = low.length(); i <= high.length(); ++i) dfs(ans, low, high, new char[i], 0, i - 1);
    return ans[0];
}

private void dfs(int[] ans, String low, String high, char[] tmp, int l, int r) {
    if (l > r) {
        String s = new String(tmp);
        if (s.length() == low.length() && s.compareTo(low) < 0) return;
        if (s.length() == high.length() && s.compareTo(high) > 0) return;
        ans[0]++;
        return;
    }
    for (char[] pair : pairs) {
        tmp[l] = pair[0];
        tmp[r] = pair[1];
        if (l == r && pair[0] != pair[1]) continue;
        if (tmp.length > 1 && tmp[0] == '0') continue;
        dfs(ans, low, high, tmp, l + 1, r - 1);
    }
}




