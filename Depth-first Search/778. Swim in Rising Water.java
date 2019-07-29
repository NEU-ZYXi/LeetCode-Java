
/*

On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
Now rain starts to fall. At time t, the depth of the water everywhere is t. 
You can swim from a square to another 4-directionally adjacent square 
if and only if the elevation of both squares individually are at most t. 
You can swim infinite distance in zero time. 
Of course, you must stay within the boundaries of the grid during your swim.
You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

Example 1:
Input: [[0,2],[1,3]]
Output: 3
Explanation:
At time 0, you are in grid location (0, 0).
You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
You cannot reach point (1, 1) until time 3.
When the depth of water is 3, we can swim anywhere inside the grid.

Example 2:
Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
Output: 16
Explanation:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6
The final route is marked in bold.
We need to wait until time 16 so that (0, 0) and (4, 4) are connected.

*/

/*

Solution: dijsktra DFS to find the path with least depth using a priority queue
O(nmlog(nm)),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int swimInWater(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[2] - b[2];
        }
    });
    boolean[][] vis = new boolean[n][m];
    vis[0][0] = true;
    pq.offer(new int[] {0, 0, grid[0][0]});
    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int x = cur[0], y = cur[1], depth = cur[2];
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    int time = Math.max(depth, grid[nx][ny]);
                    if (nx == n - 1 && ny == m - 1) {
                        return time;
                    }
                    pq.offer(new int[] {nx, ny, time});
                }
            }
        }
    }
    return 0;
}



