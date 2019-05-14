
/*

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
The island doesn't have "lakes" (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. 
Determine the perimeter of the island. 

Example:
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
Output: 16

*/

/*

Solution 1: O(nm),O(1)

*/

public int islandPerimeter(int[][] grid) {
    int cnt = 0, neighbor = 0, n = grid.length, m = grid[0].length;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) {
                cnt++;
                if (i < n - 1 && grid[i + 1][j] == 1) neighbor++;
                if (j < m - 1 && grid[i][j + 1] == 1) neighbor++;
            }
        }
    }
    return cnt * 4 - neighbor * 2;
}


/*

Solution 2: O(nm),O(1)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int islandPerimeter(int[][] grid) {
    int ans = 0, n = grid.length, m = grid[0].length;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) ans += dfs(grid, i, j);
        }
    }
    return ans;
}

private int dfs(int[][] grid, int x, int y) {
    int ans = 0, n = grid.length, m = grid[0].length, cnt = 0;
    grid[x][y] = -1;
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] != 0) {
            if (grid[nx][ny] == -1) {
                cnt++;
                continue;
            }
            cnt++;
            ans += dfs(grid, nx, ny);
        }
    }
    ans += 4 - cnt;
    return ans;
}





