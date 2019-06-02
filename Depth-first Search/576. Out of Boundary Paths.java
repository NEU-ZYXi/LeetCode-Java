
/*

There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, 
you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). 
However, you can at most move N times. 
Find out the number of paths to move the ball out of grid boundary. 
The answer may be very large, return it after mod 109 + 7.

Example 1:
Input: m = 2, n = 2, N = 2, i = 0, j = 0
Output: 6

Example 2:
Input: m = 1, n = 3, N = 3, i = 0, j = 1
Output: 12

*/

/*

Solution 1: use DFS with memo, memo[i][j][N] means the number of paths to get to (i,j) with N moves left
O(nmN),O(nmN)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
private int MOD = 1000000007;

public int findPaths(int m, int n, int N, int i, int j) {
    int[][][] memo = new int[m][n][N + 1];
    for (int[][] p : memo) {
        for (int[] q : p) {
            Arrays.fill(q, -1);
        }
    }
    return dfs(memo, m, n, N, i, j);
}

private int dfs(int[][][] memo, int m, int n, int N, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n) {
        return 1;
    }
    if (N <= 0) {
        return 0;
    }
    if (memo[i][j][N] != -1) {
        return memo[i][j][N];
    }
    int ans = 0;
    for (int[] dir : dirs) {
        int ni = i + dir[0], nj = j + dir[1];
        ans = (ans + dfs(memo, m, n, N - 1, ni, nj) % MOD) % MOD;
    }
    memo[i][j][N] = ans;
    return ans;
}


/*

Solution 2: use DP to implement same intuition before
O(nmN),O(nmN)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
private int MOD = 1000000007;

public int findPaths(int m, int n, int N, int i, int j) {
    int[][] dp = new int[m][n];
    dp[i][j] = 1;
    int ans = 0;
    for (int move = 0; move < N; ++move) {
        int[][] tmp = new int[m][n];
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (0 <= nr && nr < m && 0 <= nc && nc < n) {
                        tmp[nr][nc] = (tmp[nr][nc] + dp[r][c]) % MOD;
                    } else {
                        ans = (ans + dp[r][c]) % MOD;
                    }
                }
            }
        }
        dp = tmp;
    }
    return ans;
}





