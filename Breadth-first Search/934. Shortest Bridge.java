
/*

In a given 2D binary array A, there are two islands.  
(An island is a 4-directionally connected group of 1s not connected to any other 1s.)
Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

Example 1:
Input: [[0,1],[1,0]]
Output: 1

Example 2:
Input: [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

Example 3:
Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1

*/

/*

Solution: DFS find one island and mark this island as visited, BFS to expand this island until finding the other one
O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int shortestBridge(int[][] A) {
    int n = A.length, m = A[0].length, ans = 0;
    boolean[][] vis = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    boolean found = false;
    for (int i = 0; i < n; ++i) {
        if (!found) {
            for (int j = 0; j < m; ++j) {
                if (A[i][j] == 1) {
                    dfs(A, queue, vis, i, j);
                    found = true;
                    break;
                }
            }
        }
    }
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !vis[nx][ny]) {
                    if (A[nx][ny] == 1) {
                        return ans;
                    }
                    vis[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        ans++;
    }
    return -1;
}

private void dfs(int[][] A, Queue<int[]> queue, boolean[][] vis, int x, int y) {
    int n = A.length, m = A[0].length;
    vis[x][y] = true;
    queue.offer(new int[] {x, y});
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && A[nx][ny] == 1 && !vis[nx][ny]) {
            dfs(A, queue, vis, nx, ny);
        }
    }
}





