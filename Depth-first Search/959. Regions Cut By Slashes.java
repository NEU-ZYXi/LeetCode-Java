
/*

In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  
These characters divide the square into contiguous regions.
(Note that backslash characters are escaped, so a \ is represented as "\\".)
Return the number of regions.

Example 1:
Input:
[
  " /",
  "/ "
]
Output: 2

Example 2:
Input:
[
  " /",
  "  "
]
Output: 1

Example 3:
Input:
[
  "\\/",
  "/\\"
]
Output: 4

Example 4:
Input:
[
  "/\\",
  "\\/"
]
Output: 5

Example 5:
Input:
[
  "//",
  "/ "
]
Output: 3

*/

/*

Solution: expand the graph 3 times to separate continuous '/' or '\', then DFS to find the number of islands
O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int regionsBySlashes(String[] grid) {
    int ans = 0, n = grid.length, m = grid[0].length();
    int[][] mat = new int[n * 3][m * 3];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i].charAt(j) == '/') {
                mat[i * 3][j * 3 + 2] = 1;
                mat[i * 3 + 1][j * 3 + 1] = 1;
                mat[i * 3 + 2][j * 3] = 1;
            } else if (grid[i].charAt(j) == '\\') {
                mat[i * 3][j * 3] = 1;
                mat[i * 3 + 1][j * 3 + 1] = 1;
                mat[i * 3 + 2][j * 3 + 2] = 1;
            }
        }
    }
    for (int i = 0; i < mat.length; ++i) {
        for (int j = 0; j < mat[0].length; ++j) {
            if (mat[i][j] == 0) {
                ans++;
                dfs(mat, i, j);
            }
        }
    }
    return ans;
}

private void dfs(int[][] mat, int x, int y) {
    if (x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] == 1) {
        return;
    }
    mat[x][y] = 1;
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        dfs(mat, nx, ny);
    }
}




