
/*

You have a set of tiles, where each tile has one letter tiles[i] printed on it.
Return the number of possible non-empty sequences of letters you can make.

Example 1:
Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: "AAABBC"
Output: 188

*/

/*

O(26^n),O(n)

*/

public int numTilePossibilities(String tiles) {
    int[] buckets = new int[26];
    for (char c : tiles.toCharArray()) {
        buckets[c - 'A']++;
    }
    return dfs(buckets);
}

private int dfs(int[] buckets) {
    int ans = 0;
    for (int i = 0; i < 26; ++i) {
        if (buckets[i] != 0) {
            buckets[i]--;
            ans++;
            ans += dfs(buckets);
            buckets[i]++;
        }
    }
    return ans;
}



