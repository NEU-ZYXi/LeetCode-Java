
/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3

*/

/*

Solution 1: DFS for each '1' and flood fill to mark all its neighbors '1' as '0'
O(nm),O(1)

*/

private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
public int numIslands(char[][] grid) {
    if (grid.length == 0) return 0;
    int ans = 0, n = grid.length, m = grid[0].length;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == '1') {
                ans++;
                dfs(grid, i, j);
            }
        }
    }
    return ans;
}

private void dfs(char[][] grid, int x, int y) {
    int n = grid.length, m = grid[0].length;
    grid[x][y] = '0';
    for (int i = 0; i < 4; ++i) {
        int nx = x + dirs[i][0], ny = y + dirs[i][1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == '1') dfs(grid, nx, ny);
    }
}


/*

Solution 2: use BFS for each '1' as above
O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int numIslands(char[][] grid) {
    if (grid.length == 0) return 0;
    int ans = 0, n = grid.length, m = grid[0].length;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == '1') {
                ans++;
                bfs(grid, i, j);
            }
        }
    }
    return ans;
}

private void bfs(char[][] grid, int x, int y) {
    int n = grid.length, m = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {x, y});
    grid[x][y] = '0';
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            int[] cur = queue.poll();
            for (int j = 0; j < 4; ++j) {
                int nx = cur[0] + dirs[j][0], ny = cur[1] + dirs[j][1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == '1') {
                    queue.offer(new int[] {nx, ny});
                    grid[nx][ny] = '0';
                }
            }
        }
    }
}


/*

Solution 3: union-find, count all the '1', and if we could union two adjacent '1', decrease the total counts by 1
O(nm),O(nm)

*/

public int numIslands(char[][] grid) {
    if (grid.length == 0) return 0;
    int ans = 0, n = grid.length, m = grid[0].length;
    int[] id = new int[n * m];
    int[] rank = new int[n * m];
    for (int i = 0; i < n * m; ++i) {
        id[i] = i;
        rank[i] = 1;
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == '1') ans++;
        }
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == '1') {
                int p = i * m + j;
                if (j < m - 1 && grid[i][j + 1] == '1') {
                    int q = i * m + j + 1;
                    if (find(id, p) != find(id, q)) {
                        ans--;
                        union(id, rank, p, q);
                    }
                }
                if (i < n - 1 && grid[i + 1][j] == '1') {
                    int q = (i + 1) * m + j;
                    if (find(id, p) != find(id, q)) {
                        ans--;
                        union(id, rank, p, q);
                    }
                }
            }
        }
    }
    return ans;
}

private int find(int[] id, int i) {
    while (i != id[i]) {
        i = id[i];
        id[i] = id[id[i]];
    }
    return i;
}

private void union(int[] id, int[] rank, int p, int q) {
    int rootP = find(id, p), rootQ = find(id, q);
    if (rootP == rootQ) return;
    else if (rank[rootP] > rank[rootQ]) {
        id[rootQ] = rootP;
        rank[rootP] += rank[rootQ];
    } else {
        id[rootP] = rootQ;
        rank[rootQ] += rank[rootP];
    }
}




