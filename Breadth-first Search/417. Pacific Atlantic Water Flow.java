
/*

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.

Example:
Given the following 5x5 matrix:
  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic
Return:
[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

*/

/*

O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> ans = new ArrayList<>();
    if (matrix.length == 0) return ans;
    int n = matrix.length, m = matrix[0].length;
    boolean[][] matP = new boolean[n][m], matA = new boolean[n][m];
    Queue<int[]> queueP = new LinkedList<>(), queueA = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
        matP[i][0] = matA[i][m - 1] = true;
        queueP.offer(new int[] {i, 0});
        queueA.offer(new int[] {i, m - 1});
    }
    for (int j = 0; j < m; ++j) {
        matP[0][j] = matA[n - 1][j] = true;
        queueP.offer(new int[] {0, j});
        queueA.offer(new int[] {n - 1, j});
    }
    bfs(matrix, matP, queueP);
    bfs(matrix, matA, queueA);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (matP[i][j] && matA[i][j]) ans.add(new int[] {i, j});
        }
    }
    return ans;
}

private void bfs(int[][] matrix, boolean[][] ocean, Queue<int[]> queue) {
    int n = matrix.length, m = matrix[0].length;
    while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        int x = cur[0], y = cur[1];
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && !ocean[nx][ny] && matrix[nx][ny] >= matrix[x][y]) {
                ocean[nx][ny] = true;
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}




