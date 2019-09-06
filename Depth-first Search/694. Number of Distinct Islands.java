
/*

Given a non-empty 2D array grid of 0's and 1's, 
an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.
Count the number of distinct islands.
An island is considered to be the same as another 
if and only if one island can be translated (and not rotated or reflected) to equal the other.

Example 1:
11000
11000
00011
00011
Given the above grid map, return 1.

Example 2:
11011
10000
00001
11011
Given the above grid map, return 3.
Notice that:
11
1
and
 1
11
are considered different island shapes, because we do not consider reflection / rotation.

*/

/*

Solution: keep track of current path of directions, note to append '#' as no any direction to turn
O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
private String[] paths = new String[] {"d", "u", "r", "l"};

public int numDistinctIslands(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) {
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, sb, "");
                set.add(sb.toString());
            }
        }
    }
    return set.size();
}

private void dfs(int[][] grid, int x, int y, StringBuilder sb, String path) {
    int n = grid.length, m = grid[0].length;
    grid[x][y] = 0;
    sb.append(path);
    for (int i = 0; i < 4; ++i) {
        int nx = x + dirs[i][0], ny = y + dirs[i][1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == 1) {
            dfs(grid, nx, ny, sb, paths[i]);
        }
    }
    sb.append("#");
}




