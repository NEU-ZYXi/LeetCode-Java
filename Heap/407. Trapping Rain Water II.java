
/*

Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, 
compute the volume of water it is able to trap after raining.

Example:
Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]
Return 4.

*/

/*

Solution: use a priority queue to maintain the current boundary elements with height in ascending order
          put all initial boundary elements inside the priority queue first
          BFS for each element, compare it with its four adjacent elements if not visited
          if its neighbor is lower, we could trap water, then put new boundary inside priority queue which is the larger one
O((n+m)log(n+m)),O(n+m)          

*/

private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
public int trapRainWater(int[][] heightMap) {
    if (heightMap.length == 0) return 0;
    int n = heightMap.length, m = heightMap[0].length, ans = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[2] - b[2];
        }
    });
    boolean[][] vis = new boolean[n][m];
    for (int i = 0; i < n; ++i) {
        pq.offer(new int[] {i, 0, heightMap[i][0]});
        pq.offer(new int[] {i, m - 1, heightMap[i][m - 1]});
        vis[i][0] = vis[i][m - 1] = true;
    }
    for (int i = 0; i < m; ++i) {
        pq.offer(new int[] {0, i, heightMap[0][i]});
        pq.offer(new int[] {n - 1, i, heightMap[n - 1][i]});
        vis[0][i] = vis[n - 1][i] = true;
    }
    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int x = cur[0], y = cur[1];
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && !vis[nx][ny]) {
                vis[nx][ny] = true;
                if (heightMap[nx][ny] < cur[2]) ans += cur[2] - heightMap[nx][ny]; 
                pq.offer(new int[] {nx, ny, Math.max(cur[2], heightMap[nx][ny])});
            }
        }
    }
    return ans;
}




