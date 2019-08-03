
/*

A chess knight can move as indicated in the chess diagram.
This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops. 
Each hop must be from one key to another numbered key.
Each time it lands on a key (including the initial placement of the knight), 
it presses the number of that key, pressing N digits total.
How many distinct numbers can you dial in this manner?
Since the answer may be large, output the answer modulo 10^9 + 7.

Example 1:
Input: 1
Output: 10

Example 2:
Input: 2
Output: 20

Example 3:
Input: 3
Output: 46

*/

/*

Solution: for each cell, jump next possible cell and use a memo for DFS
O(n),O(n)

*/

private int[][] dirs = new int[][] {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
private int MOD = 1000000007;

public int knightDialer(int N) {
    int[][] memo = new int[N + 1][10];
    int ans = 0;
    for (int i = 0; i <= 9; ++i) {
        ans = (ans + dfs(memo, N - 1, i)) % MOD;
    }
    return ans;
}

private int dfs(int[][] memo, int N, int cur) {
    if (N == 0) {
        return 1;
    }
    if (memo[N][cur] != 0) {
        return memo[N][cur];
    }
    int ans = 0;
    for (int next : dirs[cur]) {
        ans = (ans + dfs(memo, N - 1, next)) % MOD;
    }
    memo[N][cur] = ans;
    return ans;
}




