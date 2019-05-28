
/*

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Example 1:
Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
 
Example 2:
Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]
Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]

*/

/*

Solution 1: BFS from '0' cell to expand and update distance
O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int[][] updateMatrix(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] vis = new boolean[n][m];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (matrix[i][j] == 0) {
                vis[i][j] = true;
                queue.offer(new int[] {i, j});
            }
        }
    }
    while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        for (int[] dir : dirs) {
            int nx = cur[0] + dir[0], ny = cur[1] + dir[1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && !vis[nx][ny]) {
                vis[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
                matrix[nx][ny] = matrix[cur[0]][cur[1]] + 1;
            }
        }
    }
    return matrix;
}


/*

Solution 2: dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i+1][j],dp[i][j+1])+1
O(nm),O(nm)

*/

public int[][] updateMatrix(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    int[][] dp = new int[n][m];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (matrix[i][j] == 1) {
                dp[i][j] = n + m;
            }
            if (i > 0) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
            }
            if (j > 0) {
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
    }
    for (int i = n - 1; i >= 0; --i) {
        for (int j = m - 1; j >= 0; --j) {
            if (i < n - 1) {
                dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
            }
            if (j < m - 1) {
                dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
            }
        }
    }
    return dp;
}




