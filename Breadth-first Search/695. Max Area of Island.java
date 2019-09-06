
/*

Given a non-empty 2D array grid of 0's and 1's, 
an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.
Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.

*/

/*

Solution 1: O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int maxAreaOfIsland(int[][] grid) {
    int n = grid.length, m = grid[0].length, ans = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
    }
    return ans;
}

private int dfs(int[][] grid, int x, int y) {
    int n = grid.length, m = grid[0].length, ans = 1;
    grid[x][y] = 0;
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == 1) {
            ans += dfs(grid, nx, ny);
        }
    }
    return ans;
}


/*

Solution 2: O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int maxAreaOfIsland(int[][] grid) {
    int n = grid.length, m = grid[0].length, ans = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) {
                ans = Math.max(ans, bfs(grid, i, j));
            }
        }
    }
    return ans;
}

private int bfs(int[][] grid, int x, int y) {
    int n = grid.length, m = grid[0].length, ans = 1;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {x, y});
    grid[x][y] = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0], ny = cur[1] + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == 1) {
                    grid[nx][ny] = 0;
                    queue.offer(new int[] {nx, ny});
                    ans++;
                }
            }
        }
    }
    return ans;
}




