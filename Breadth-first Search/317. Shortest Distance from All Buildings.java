
/*

You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. 
You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.

Example:
Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
Output: 7 
Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.

*/

/*

Solution: 1. start from all buildings, and calculate its distance to each empty cell, count reachable buildings of each cell
          2. extra check to early termination
          3. for all possible cells, find the minimum distance
O(n^2m^2)          

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int shortestDistance(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int[][] dist = new int[n][m];
    int[][] reachableBuildings = new int[n][m];
    int numOfBuildings = 0, ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) {
                Queue<int[]> queue = new LinkedList<>();
                boolean[][] vis = new boolean[n][m];
                numOfBuildings++;
                int cnt = 1;
                queue.offer(new int[] {i, j});
                while (!queue.isEmpty()) {
                    int sz = queue.size();
                    for (int k = 0; k < sz; ++k) {
                        int[] cur = queue.poll();
                        int x = cur[0], y = cur[1];
                        for (int[] dir : dirs) {
                            int nx = x + dir[0], ny = y + dir[1];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m && !vis[nx][ny] && grid[nx][ny] != 2) {
                                vis[nx][ny] = true;
                                if (grid[nx][ny] == 0) {
                                    queue.offer(new int[] {nx, ny});
                                    dist[nx][ny] += cnt;
                                    reachableBuildings[nx][ny]++;
                                }
                            }
                        }
                    }
                    cnt++;
                }
                for (int r = 0; r < n; ++r) {
                    for (int c = 0; c < m; ++c) {
                        if (grid[r][c] == 1 && !vis[r][c]) return -1;
                    }
                }
            }
        }
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 0 && reachableBuildings[i][j] == numOfBuildings) ans = Math.min(ans, dist[i][j]);
        }
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
}




