
/*

In an N by N square grid, each cell is either empty (0) or blocked (1).
A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

Example 1:
Input: [[0,1],[1,0]]
Output: 2

Example 2:
Input: [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

*/

/*

O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 0}, {1, 1}};
    
public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length, m = grid[0].length, ans = 0;
    if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
        return -1;
    }
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] vis = new boolean[n][m];
    queue.offer(new int[] {0, 0});
    vis[0][0] = true;
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x == n - 1 && y == m - 1) {
                return ans + 1;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == 0 && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        ans++;
    }
    return -1;
}




