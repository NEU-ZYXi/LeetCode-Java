
/*

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally 
(horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
Count the number of distinct islands. 
An island is considered to be the same as another if they have the same shape, 
or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down direction).

Example 1:
11000
10000
00001
00011
Given the above grid map, return 1. 
Notice that:
11
1
and
 1
11
are considered same island shapes. 
Because if we make a 180 degrees clockwise rotation on the first island, then two islands will have the same shapes.

Example 2:
11100
10001
01001
01110
Given the above grid map, return 2.
Here are the two distinct islands:
111
1
and
1
1
Notice that:
111
1
and
1
111
are considered same island shapes. 
Because if we flip the first array in the up/down direction, then they have the same shapes.

*/

/*

Solution: for each island, use coordinate hash
O(n^2*m^2),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
private int[][] trans = new int[][] {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

public int numDistinctIslands2(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    Set<String> ans = new HashSet<>();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) {
                List<int[]> cells = new ArrayList<>();
                dfs(grid, cells, i, j);
                String hash = getHash(cells);
                ans.add(hash);
            }
        }
    }
    return ans.size();
}

private void dfs(int[][] grid, List<int[]> cells, int x, int y) {
    int n = grid.length, m = grid[0].length;
    cells.add(new int[] {x, y});
    grid[x][y] = 0;
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == 1) {
            dfs(grid, cells, nx, ny);
        }
    }
}

private String getHash(List<int[]> cells) {
    List<String> hash = new ArrayList<>();
    for (int[] t : trans) {
        List<int[]> shape1 = new ArrayList<>();
        List<int[]> shape2 = new ArrayList<>();
        for (int[] cell : cells) {
            int x = cell[0], y = cell[1];
            shape1.add(new int[] {x * t[0], y * t[1]});
            shape2.add(new int[] {y * t[0], x * t[1]});
        }
        for (List<int[]> shape : Arrays.asList(shape1, shape2)) {
            shape.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
                }
            });
            int x = shape.get(0)[0], y = shape.get(0)[1];
            StringBuilder sb = new StringBuilder();
            for (int[] p : shape) {
                sb.append(p[0] - x).append(",").append(p[1] - y).append(","); 
            }
            hash.add(sb.toString());
        }
    }
    Collections.sort(hash);
    return hash.get(0);
}





