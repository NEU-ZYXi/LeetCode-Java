
/*

Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point 
until it hits the wall since the wall is too strong to be destroyed.
Note: You can only put the bomb at an empty cell.

Example:
Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3 
Explanation: For the given grid,
0 E 0 0 
E 0 W E 
0 E 0 0
Placing a bomb at (1,1) kills 3 enemies.

*/

/*

O(nm),O(nm)

*/

public int maxKilledEnemies(char[][] grid) {
    if (grid.length == 0) return 0;
    int ans = 0, n = grid.length, m = grid[0].length;
    int[][] cnt = new int[n][m];
    for (int i = 0; i < n; ++i) {
        int sum = 0;
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 'W') sum = 0;
            else if (grid[i][j] == 'E') sum++;
            else cnt[i][j] = sum;
        }
        sum = 0;
        for (int j = m - 1; j >= 0; --j) {
            if (grid[i][j] == 'W') sum = 0;
            else if (grid[i][j] == 'E') sum++;
            else cnt[i][j] += sum;
        }
    }
    for (int j = 0; j < m; ++j) {
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            if (grid[i][j] == 'W') sum = 0;
            else if (grid[i][j] == 'E') sum++;
            else cnt[i][j] += sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (grid[i][j] == 'W') sum = 0;
            else if (grid[i][j] == 'E') sum++;
            else {
                cnt[i][j] += sum;
                ans = Math.max(ans, cnt[i][j]);
            }
        }
    }
    return ans;
}




