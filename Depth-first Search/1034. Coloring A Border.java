
/*

Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.
Two squares belong to the same connected component if and only if they have the same color 
and are next to each other in any of the 4 directions.
The border of a connected component is all the squares in the connected component 
that are either 4-directionally adjacent to a square not in the component, 
or on the boundary of the grid (the first or last row or column).
Given a square at location (r0, c0) in the grid and a color, 
color the border of the connected component of that square with the given color, and return the final grid. 

Example 1:
Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
Output: [[3, 3], [3, 2]]

Example 2:
Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
Output: [[1, 3, 3], [2, 3, 3]]

Example 3:
Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]

*/

/*

O(nm),O(n+m)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
    dfs(grid, r0, c0, grid[r0][c0]);
    for (int i = 0; i < grid.length; ++i) {
        for (int j = 0; j < grid[0].length; ++j) {
            if (grid[i][j] < 0) {
                grid[i][j] = color;
            }
        }
    }
    return grid;
}

private void dfs(int[][] grid, int x, int y, int color) {
    int n = grid.length, m = grid[0].length, cnt = 0;
    if (grid[x][y] == color) {
        grid[x][y] = -1;
    }
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
            if (grid[nx][ny] != color) {
                if (grid[nx][ny] == -1) {
                    cnt++;
                }
                continue;
            } else {
                cnt++;
                dfs(grid, nx, ny, color);
            }
        }
    }
    if (cnt == 4) {
        grid[x][y] = color;
    }
}




