
/*

Given a matrix of integers A with R rows and C columns, 
find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions.

Example 1:
Input: [[5,4,5],[1,2,6],[7,4,6]]
Output: 4
Explanation: 
The path with the maximum score is highlighted in yellow. 

Example 2:
Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
Output: 2

Example 3:
Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
Output: 3

*/

/*

O(nmlog(nm)),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int maximumMinimumPath(int[][] A) {
    int n = A.length, m = A[0].length;
    int[][] matrix = new int[n][m];
    for (int[] row : matrix) {
        Arrays.fill(row, -1);
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int [] b) {
            return b[2] - a[2];
        }
    });
    pq.offer(new int[] {0, 0, A[0][0]});
    matrix[0][0] = A[0][0];
    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int x = cur[0], y = cur[1], val = cur[2];
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && matrix[nx][ny] == -1) {
                matrix[nx][ny] = Math.min(A[nx][ny], val);
                if (nx == n - 1 && ny == m - 1) {
                    return matrix[nx][ny];
                }
                pq.offer(new int[] {nx, ny, matrix[nx][ny]});
            }
        }
    }
    return -1;
}



