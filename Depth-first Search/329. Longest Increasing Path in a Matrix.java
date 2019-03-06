
/*

Given an integer matrix, find the length of the longest increasing path.
From each cell, you can either move to four directions: left, right, up or down. 
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:
Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:
Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

*/

/*

O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int longestIncreasingPath(int[][] matrix) {
    if (matrix.length == 0) return 0;
    int n = matrix.length, m = matrix[0].length;
    int[][] memo = new int[n][m];
    int ans = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) ans = Math.max(ans, dfs(matrix, memo, i, j));
    }
    return ans;
}

private int dfs(int[][] matrix, int[][] memo, int x, int y) {
    int n = matrix.length, m = matrix[0].length;
    if (memo[x][y] > 0) return memo[x][y];
    int ans = 1;
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && matrix[nx][ny] > matrix[x][y]) {
            ans = Math.max(ans, dfs(matrix, memo, nx, ny) + 1);
        }
    }
    memo[x][y] = ans;
    return ans;
}




