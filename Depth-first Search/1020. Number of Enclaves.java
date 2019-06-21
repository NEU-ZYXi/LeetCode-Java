
/*

Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: 
There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.

Example 2:
Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: 
All 1s are either on the boundary or can reach the boundary.

*/

/*

O(nm),O(1)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int numEnclaves(int[][] A) {
    int n = A.length, m = A[0].length, ans = 0;
    for (int i = 0; i < n; ++i) {
        if (A[i][0] == 1) {
            dfs(A, i, 0);
        }
        if (A[i][m - 1] == 1) {
            dfs(A, i, m - 1);
        }
    }
    for (int j = 0; j < m; ++j) {
        if (A[0][j] == 1) {
            dfs(A, 0, j);
        }
        if (A[n - 1][j] == 1) {
            dfs(A, n - 1, j);
        }
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (A[i][j] == 1) {
                ans++;
            }
        }
    }
    return ans;
}

private void dfs(int[][] A, int x, int y) {
    if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] == 0) {
        return;
    }
    A[x][y] = 0;
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        dfs(A, nx, ny);
    }
}



