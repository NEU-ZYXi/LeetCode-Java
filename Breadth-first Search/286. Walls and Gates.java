
/*

You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF 
as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 
Given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

*/

/*

O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public void wallsAndGates(int[][] rooms) {
    if (rooms.length == 0) return;
    int n = rooms.length, m = rooms[0].length;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (rooms[i][j] == 0) queue.offer(new int[] {i, j});
        }
    }
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || rooms[nx][ny] <= rooms[x][y] + 1) continue;
                rooms[nx][ny] = rooms[x][y] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}




