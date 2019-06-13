
/*

On a 2-dimensional grid, there are 4 types of squares:
1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, 
that walk over every non-obstacle square exactly once.

Example 1:
Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:
Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:
Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.

*/

/*

O(3^nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int uniquePathsIII(int[][] grid) {
    int total = 0, x = 0, y = 0, n = grid.length, m = grid[0].length;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 0) {
                total++;
            }
            if (grid[i][j] == 1) {
                x = i;
                y = j;
            }
        }
    }
    return dfs(grid, total + 1, x, y, 0);
}

private int dfs(int[][] grid, int total, int x, int y, int cnt) {
    int n = grid.length, m = grid[0].length, ans = 0;
    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == -1) {
        return 0;
    }
    if (grid[x][y] == 2) {
        if (cnt == total) {
            return 1;
        } else {
            return 0;
        }
    }
    grid[x][y] = -1;
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        ans += dfs(grid, total, nx, ny, cnt + 1);
    }
    grid[x][y] = 0;
    return ans;
}




